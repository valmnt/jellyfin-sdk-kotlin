// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
package org.jellyfin.sdk.model.api.request

import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jellyfin.sdk.model.api.ImageFormat
import org.jellyfin.sdk.model.api.ImageType

/**
 * Get studio image by name.
 */
@Serializable
public data class GetStudioImageRequest(
	/**
	 * Studio name.
	 */
	@SerialName("name")
	public val name: String,
	/**
	 * Image type.
	 */
	@SerialName("imageType")
	public val imageType: ImageType,
	/**
	 * Optional. Supply the cache tag from the item object to receive strong caching headers.
	 */
	@SerialName("tag")
	public val tag: String? = null,
	/**
	 * Determines the output format of the image - original,gif,jpg,png.
	 */
	@SerialName("format")
	public val format: ImageFormat? = null,
	/**
	 * The maximum image width to return.
	 */
	@SerialName("maxWidth")
	public val maxWidth: Int? = null,
	/**
	 * The maximum image height to return.
	 */
	@SerialName("maxHeight")
	public val maxHeight: Int? = null,
	/**
	 * Optional. Percent to render for the percent played overlay.
	 */
	@SerialName("percentPlayed")
	public val percentPlayed: Double? = null,
	/**
	 * Optional. Unplayed count overlay to render.
	 */
	@SerialName("unplayedCount")
	public val unplayedCount: Int? = null,
	/**
	 * The fixed image width to return.
	 */
	@SerialName("width")
	public val width: Int? = null,
	/**
	 * The fixed image height to return.
	 */
	@SerialName("height")
	public val height: Int? = null,
	/**
	 * Optional. Quality setting, from 0-100. Defaults to 90 and should suffice in most cases.
	 */
	@SerialName("quality")
	public val quality: Int? = null,
	/**
	 * Width of box to fill.
	 */
	@SerialName("fillWidth")
	public val fillWidth: Int? = null,
	/**
	 * Height of box to fill.
	 */
	@SerialName("fillHeight")
	public val fillHeight: Int? = null,
	/**
	 * Optional. Blur image.
	 */
	@SerialName("blur")
	public val blur: Int? = null,
	/**
	 * Optional. Apply a background color for transparent images.
	 */
	@SerialName("backgroundColor")
	public val backgroundColor: String? = null,
	/**
	 * Optional. Apply a foreground layer on top of the image.
	 */
	@SerialName("foregroundLayer")
	public val foregroundLayer: String? = null,
	/**
	 * Image index.
	 */
	@SerialName("imageIndex")
	public val imageIndex: Int? = null,
)
