// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
@file:UseSerializers(UUIDSerializer::class)

package org.jellyfin.sdk.model.api

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import org.jellyfin.sdk.model.UUID
import org.jellyfin.sdk.model.serializer.UUIDSerializer

/**
 * Plabyback info dto.
 */
@Serializable
public data class PlaybackInfoDto(
	/**
	 * The playback userId.
	 */
	@SerialName("UserId")
	public val userId: UUID? = null,
	/**
	 * The max streaming bitrate.
	 */
	@SerialName("MaxStreamingBitrate")
	public val maxStreamingBitrate: Int? = null,
	/**
	 * The start time in ticks.
	 */
	@SerialName("StartTimeTicks")
	public val startTimeTicks: Long? = null,
	/**
	 * The audio stream index.
	 */
	@SerialName("AudioStreamIndex")
	public val audioStreamIndex: Int? = null,
	/**
	 * The subtitle stream index.
	 */
	@SerialName("SubtitleStreamIndex")
	public val subtitleStreamIndex: Int? = null,
	/**
	 * The max audio channels.
	 */
	@SerialName("MaxAudioChannels")
	public val maxAudioChannels: Int? = null,
	/**
	 * The media source id.
	 */
	@SerialName("MediaSourceId")
	public val mediaSourceId: String? = null,
	/**
	 * The live stream id.
	 */
	@SerialName("LiveStreamId")
	public val liveStreamId: String? = null,
	/**
	 * The device profile.
	 */
	@SerialName("DeviceProfile")
	public val deviceProfile: DeviceProfile? = null,
	/**
	 * A value indicating whether to enable direct play.
	 */
	@SerialName("EnableDirectPlay")
	public val enableDirectPlay: Boolean? = null,
	/**
	 * A value indicating whether to enable direct stream.
	 */
	@SerialName("EnableDirectStream")
	public val enableDirectStream: Boolean? = null,
	/**
	 * A value indicating whether to enable transcoding.
	 */
	@SerialName("EnableTranscoding")
	public val enableTranscoding: Boolean? = null,
	/**
	 * A value indicating whether to enable video stream copy.
	 */
	@SerialName("AllowVideoStreamCopy")
	public val allowVideoStreamCopy: Boolean? = null,
	/**
	 * A value indicating whether to allow audio stream copy.
	 */
	@SerialName("AllowAudioStreamCopy")
	public val allowAudioStreamCopy: Boolean? = null,
	/**
	 * A value indicating whether to auto open the live stream.
	 */
	@SerialName("AutoOpenLiveStream")
	public val autoOpenLiveStream: Boolean? = null,
)
