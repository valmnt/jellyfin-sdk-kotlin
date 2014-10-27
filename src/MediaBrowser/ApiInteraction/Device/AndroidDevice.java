package MediaBrowser.ApiInteraction.Device;

import MediaBrowser.ApiInteraction.ApiClient;
import MediaBrowser.Model.Devices.LocalFileInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;

import java.util.ArrayList;
import java.util.Observable;

public class AndroidDevice implements IDevice{

    private final String deviceName;
    private final String deviceId;

    private Context context;

    public AndroidDevice(Context context){

        this.context = context;

        deviceId = getDeviceIdInternal(context);
        deviceName = getDeviceNameInternal();
    }

    @Override
    public String getDeviceName() {

        return deviceName;
    }

    @Override
    public String getDeviceId() {

        return deviceId;
    }

    @Override
    public ArrayList<LocalFileInfo> GetLocalPhotos() {

        // which image properties are we querying
        String[] projection = new String[]{
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
                MediaStore.Images.Media.DATE_TAKEN,
                MediaStore.Images.Media.MIME_TYPE,
                MediaStore.Images.Media.TITLE,
                MediaStore.Images.Media.DISPLAY_NAME
        };

        // Get the base URI for the People table in the Contacts content provider.
        Uri images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        // Make the query.
        Cursor cur = context.getContentResolver().query(images,
                projection, // Which columns to return
                null,       // Which rows to return (all rows)
                null,       // Selection arguments (none)
                null        // Ordering
        );

        ArrayList<LocalFileInfo> files = new ArrayList<LocalFileInfo>();

        if (cur.moveToFirst()) {
            String bucket;
            String date;
            String id;
            String title;
            String displayName;
            String mimeType;
            int bucketColumn = cur.getColumnIndex(
                    MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

            int dateColumn = cur.getColumnIndex(
                    MediaStore.Images.Media.DATE_TAKEN);

            int idColumn = cur.getColumnIndex(
                    MediaStore.Images.Media._ID);

            int titleColumn = cur.getColumnIndex(
                    MediaStore.Images.Media.TITLE);

            int displayNameColumn = cur.getColumnIndex(
                    MediaStore.Images.Media.DISPLAY_NAME);

            int mimeTypeColumn = cur.getColumnIndex(
                    MediaStore.Images.Media.MIME_TYPE);

            do {
                // Get the field values
                bucket = cur.getString(bucketColumn);
                date = cur.getString(dateColumn);
                id = cur.getString(idColumn);
                title = cur.getString(titleColumn);
                displayName = cur.getString(displayNameColumn);
                mimeType = cur.getString(mimeTypeColumn);

                LocalFileInfo file = new LocalFileInfo();

                file.setAlbum(bucket);
                file.setId(id);
                file.setMimeType(mimeType);
                file.setName(displayName);

                files.add(file);

            } while (cur.moveToNext());

        }

        return files;
    }

    @Override
    public ArrayList<LocalFileInfo> GetLocalVideos() {

        return new ArrayList<LocalFileInfo>();
    }

    private String getDeviceIdInternal(Context context) {

        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    private String getDeviceNameInternal() {

        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        } else {
            return manufacturer + " " + model;
        }
    }

    private Observable resumeFromSleepObservable = new Observable();
    @Override
    public Observable getResumeFromSleepObservable() {
        return resumeFromSleepObservable;
    }

    @Override
    public void UploadFile(LocalFileInfo file, ApiClient apiClient) {


    }

}
