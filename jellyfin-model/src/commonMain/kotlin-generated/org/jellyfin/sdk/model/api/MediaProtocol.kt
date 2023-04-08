// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
package org.jellyfin.sdk.model.api

import kotlin.String
import kotlin.requireNotNull
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class MediaProtocol(
	public val serialName: String,
) {
	@SerialName("File")
	FILE("File"),
	@SerialName("Http")
	HTTP("Http"),
	@SerialName("Rtmp")
	RTMP("Rtmp"),
	@SerialName("Rtsp")
	RTSP("Rtsp"),
	@SerialName("Udp")
	UDP("Udp"),
	@SerialName("Rtp")
	RTP("Rtp"),
	@SerialName("Ftp")
	FTP("Ftp"),
	;

	/**
	 * Get the serial name of the enum member.
	 */
	public override fun toString(): String = serialName

	public companion object {
		/**
		 * Find the enum member by the serial name or return null.
		 */
		public fun fromNameOrNull(serialName: String): MediaProtocol? = when (serialName) {
			"File" -> FILE
			"Http" -> HTTP
			"Rtmp" -> RTMP
			"Rtsp" -> RTSP
			"Udp" -> UDP
			"Rtp" -> RTP
			"Ftp" -> FTP
			else -> null
		}

		/**
		 * Find the enum member by the serial name or throw.
		 */
		public fun fromName(serialName: String): MediaProtocol =
				requireNotNull(fromNameOrNull(serialName)) { """Unknown value $serialName""" }
	}
}
