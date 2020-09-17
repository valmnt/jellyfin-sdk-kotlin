// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
package org.jellyfin.apiclient.model.api

import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Class RemoteImageInfo.
 */
@Serializable
data class RemoteImageInfo(
	/**
	 * Gets or sets the name of the provider.
	 */
	@SerialName("ProviderName")
	val providerName: String? = null,
	/**
	 * Gets or sets the URL.
	 */
	@SerialName("Url")
	val url: String? = null,
	/**
	 * Gets a url used for previewing a smaller version.
	 */
	@SerialName("ThumbnailUrl")
	val thumbnailUrl: String? = null,
	/**
	 * Gets or sets the height.
	 */
	@SerialName("Height")
	val height: Int? = null,
	/**
	 * Gets or sets the width.
	 */
	@SerialName("Width")
	val width: Int? = null,
	/**
	 * Gets or sets the community rating.
	 */
	@SerialName("CommunityRating")
	val communityRating: Double? = null,
	/**
	 * Gets or sets the vote count.
	 */
	@SerialName("VoteCount")
	val voteCount: Int? = null,
	/**
	 * Gets or sets the language.
	 */
	@SerialName("Language")
	val language: String? = null,
	@SerialName("Type")
	val type: ImageType,
	@SerialName("RatingType")
	val ratingType: RatingType
)