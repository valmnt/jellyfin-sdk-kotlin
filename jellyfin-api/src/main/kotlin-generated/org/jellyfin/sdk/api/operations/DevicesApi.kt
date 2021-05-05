// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
package org.jellyfin.sdk.api.operations

import java.util.UUID
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import org.jellyfin.sdk.api.client.KtorClient
import org.jellyfin.sdk.api.client.Response
import org.jellyfin.sdk.model.api.DeviceInfo
import org.jellyfin.sdk.model.api.DeviceInfoQueryResult
import org.jellyfin.sdk.model.api.DeviceOptions

public class DevicesApi(
	private val api: KtorClient
) {
	/**
	 * Deletes a device.
	 *
	 * @param id Device Id.
	 */
	public suspend fun deleteDevice(id: String): Response<Unit> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["id"] = id
		val data = null
		val response = api.delete<Unit>("/Devices", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Get info for a device.
	 *
	 * @param id Device Id.
	 */
	public suspend fun getDeviceInfo(id: String): Response<DeviceInfo> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["id"] = id
		val data = null
		val response = api.`get`<DeviceInfo>("/Devices/Info", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Get options for a device.
	 *
	 * @param id Device Id.
	 */
	public suspend fun getDeviceOptions(id: String): Response<DeviceOptions> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["id"] = id
		val data = null
		val response = api.`get`<DeviceOptions>("/Devices/Options", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Get Devices.
	 *
	 * @param supportsSync Gets or sets a value indicating whether [supports synchronize].
	 * @param userId Gets or sets the user identifier.
	 */
	public suspend fun getDevices(supportsSync: Boolean? = null, userId: UUID? = null):
			Response<DeviceInfoQueryResult> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["supportsSync"] = supportsSync
		queryParameters["userId"] = userId
		val data = null
		val response = api.`get`<DeviceInfoQueryResult>("/Devices", pathParameters, queryParameters, data)
		return response
	}

	/**
	 * Update device options.
	 *
	 * @param id Device Id.
	 */
	public suspend fun updateDeviceOptions(id: String, `data`: DeviceOptions): Response<Unit> {
		val pathParameters = emptyMap<String, Any?>()
		val queryParameters = mutableMapOf<String, Any?>()
		queryParameters["id"] = id
		val response = api.post<Unit>("/Devices/Options", pathParameters, queryParameters, data)
		return response
	}
}
