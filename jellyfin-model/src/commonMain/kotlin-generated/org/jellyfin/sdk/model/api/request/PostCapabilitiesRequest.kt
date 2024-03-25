// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
package org.jellyfin.sdk.model.api.request

import kotlin.Boolean
import kotlin.String
import kotlin.collections.Collection
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jellyfin.sdk.model.api.GeneralCommandType
import org.jellyfin.sdk.model.api.MediaType

/**
 * Updates capabilities for a device.
 */
@Serializable
public data class PostCapabilitiesRequest(
	/**
	 * The session id.
	 */
	@SerialName("id")
	public val id: String? = null,
	/**
	 * A list of playable media types, comma delimited. Audio, Video, Book, Photo.
	 */
	@SerialName("playableMediaTypes")
	public val playableMediaTypes: Collection<MediaType>? = null,
	/**
	 * A list of supported remote control commands, comma delimited.
	 */
	@SerialName("supportedCommands")
	public val supportedCommands: Collection<GeneralCommandType>? = null,
	/**
	 * Determines whether media can be played remotely..
	 */
	@SerialName("supportsMediaControl")
	public val supportsMediaControl: Boolean? = false,
	/**
	 * Determines whether the device supports a unique identifier.
	 */
	@SerialName("supportsPersistentIdentifier")
	public val supportsPersistentIdentifier: Boolean? = true,
)
