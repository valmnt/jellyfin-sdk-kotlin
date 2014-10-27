package MediaBrowser.ApiInteraction;

import MediaBrowser.ApiInteraction.Cryptography.Md5;
import MediaBrowser.Model.ApiClient.ConnectionState;
import MediaBrowser.Model.ApiClient.ServerCredentials;
import MediaBrowser.Model.Connect.*;
import MediaBrowser.Model.Logging.ILogger;
import MediaBrowser.Model.Serialization.IJsonSerializer;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Dictionary;

public class ConnectService {

    public IJsonSerializer JsonSerializer;
    private ILogger _logger;
    private  IAsyncHttpClient _httpClient;
    private  ICredentialProvider _credentialProvider;

    public ConnectService(IJsonSerializer jsonSerializer, ILogger logger, IAsyncHttpClient httpClient, ICredentialProvider credentialProvider) {
        JsonSerializer = jsonSerializer;
        _logger = logger;
        _httpClient = httpClient;
        _credentialProvider = credentialProvider;
    }

    public void Authenticate(String username, String password, final Response<ConnectAuthenticationResult> response) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        QueryStringDictionary args = new QueryStringDictionary();

        args.Add("userName", username);
        args.Add("password", Md5.getHash(password));

        String url = GetConnectUrl("user/authenticate");

        HttpRequest request = new HttpRequest();

        request.setMethod("POST");
        request.setUrl(url);
        request.setPostData(args);

        AddUserAccessToken(request);

        _httpClient.Send(request, new Response<String>(){

            @Override
            public void onResponse(String result) {

                ConnectAuthenticationResult obj = JsonSerializer.DeserializeFromString(result, ConnectAuthenticationResult.class);

                response.onResponse(obj);
            }

            @Override
            public void onError() {

                response.onError();
            }
        });
    }

    public void CreatePin(String deviceId, final Response<PinCreationResult> response)
    {
        QueryStringDictionary args = new QueryStringDictionary();

        args.Add("deviceId", deviceId);

        String url = GetConnectUrl("pin") + "?" + args.GetQueryString();

        HttpRequest request = new HttpRequest();

        request.setMethod("POST");
        request.setUrl(url);
        request.setPostData(args);

        AddUserAccessToken(request);

        _httpClient.Send(request, new Response<String>(){

            @Override
            public void onResponse(String result) {

                PinCreationResult obj = JsonSerializer.DeserializeFromString(result, PinCreationResult.class);

                response.onResponse(obj);
            }

            @Override
            public void onError() {

                response.onError();
            }
        });
    }

    public void GetPinStatus(PinCreationResult pin, final Response<PinStatusResult> response)
    {
        QueryStringDictionary dict = new QueryStringDictionary();

        dict.Add("deviceId", pin.getDeviceId());
        dict.Add("pin", pin.getPin());

        String url = GetConnectUrl("pin") + "?" + dict.GetQueryString();

        HttpRequest request = new HttpRequest();

        request.setMethod("GET");
        request.setUrl(url);

        AddUserAccessToken(request);

        _httpClient.Send(request, new Response<String>(){

            @Override
            public void onResponse(String result) {

                PinStatusResult obj = JsonSerializer.DeserializeFromString(result, PinStatusResult.class);

                response.onResponse(obj);
            }

            @Override
            public void onError() {

                response.onError();
            }
        });
    }

    public void ExchangePin(PinCreationResult pin, final Response<PinExchangeResult> response)
    {
        QueryStringDictionary args = new QueryStringDictionary();

        args.Add("deviceId", pin.getDeviceId());
        args.Add("pin", pin.getPin());

        String url = GetConnectUrl("pin/authenticate");

        HttpRequest request = new HttpRequest();

        request.setMethod("POST");
        request.setUrl(url);
        request.setPostData(args);

        AddUserAccessToken(request);

        _httpClient.Send(request, new Response<String>(){

            @Override
            public void onResponse(String result) {

                PinExchangeResult obj = JsonSerializer.DeserializeFromString(result, PinExchangeResult.class);

                response.onResponse(obj);
            }

            @Override
            public void onError() {

                response.onError();
            }
        });
    }

    public void GetConnectUser(ConnectUserQuery query, final Response<ConnectUser> response)
    {
        QueryStringDictionary dict = new QueryStringDictionary();

        if (!tangible.DotNetToJavaStringHelper.isNullOrEmpty(query.getId()))
        {
            dict.Add("id", query.getId());
        }
        else if (!tangible.DotNetToJavaStringHelper.isNullOrEmpty(query.getName()))
        {
            dict.Add("name", query.getName());
        }
        else if (!tangible.DotNetToJavaStringHelper.isNullOrEmpty(query.getEmail()))
        {
            dict.Add("name", query.getEmail());
        }

        String url = GetConnectUrl("user") + "?" + dict.GetQueryString();

        HttpRequest request = new HttpRequest();

        request.setMethod("GET");
        request.setUrl(url);

        AddUserAccessToken(request);

        _httpClient.Send(request, new Response<String>(){

            @Override
            public void onResponse(String result) {

                ConnectUser user = JsonSerializer.DeserializeFromString(result, ConnectUser.class);

                response.onResponse(user);
            }

            @Override
            public void onError() {

                response.onError();
            }
        });
    }

    public void GetServers(String userId, final Response<ConnectUserServer[]> response)
    {
        QueryStringDictionary dict = new QueryStringDictionary();

        dict.Add("userId", userId);

        String url = GetConnectUrl("servers") + "?" + dict.GetQueryString();

        HttpRequest request = new HttpRequest();

        request.setMethod("GET");
        request.setUrl(url);

        AddUserAccessToken(request);

        _httpClient.Send(request, new Response<String>(){

            @Override
            public void onResponse(String result) {

                ConnectUserServer[] servers = JsonSerializer.DeserializeFromString(result, ConnectUserServer[].class);

                response.onResponse(servers);
            }

            @Override
            public void onError() {

                response.onError();
            }
        });
    }

    public void Logout(final EmptyResponse response)
    {
        String url = GetConnectUrl("user/logout");

        HttpRequest request = new HttpRequest();

        request.setMethod("POST");
        request.setUrl(url);

        AddUserAccessToken(request);

        _httpClient.Send(request, new Response<String>(){

            @Override
            public void onResponse(String result) {

                response.onResponse();
            }

            @Override
            public void onError() {

                response.onError();
            }
        });
    }

    private String GetConnectUrl(String handler)
    {
        return "https://connect.mediabrowser.tv/service/" + handler;
    }

    private void AddUserAccessToken(HttpRequest request)
    {
        ServerCredentials credentials = _credentialProvider.GetCredentials();

        request.getRequestHeaders().put("X-Connect-UserToken", credentials.getConnectAccessToken());
    }
}
