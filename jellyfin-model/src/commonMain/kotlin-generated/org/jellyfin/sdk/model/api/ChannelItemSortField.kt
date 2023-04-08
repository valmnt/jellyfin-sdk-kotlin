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
public enum class ChannelItemSortField(
	public val serialName: String,
) {
	@SerialName("Name")
	NAME("Name"),
	@SerialName("CommunityRating")
	COMMUNITY_RATING("CommunityRating"),
	@SerialName("PremiereDate")
	PREMIERE_DATE("PremiereDate"),
	@SerialName("DateCreated")
	DATE_CREATED("DateCreated"),
	@SerialName("Runtime")
	RUNTIME("Runtime"),
	@SerialName("PlayCount")
	PLAY_COUNT("PlayCount"),
	@SerialName("CommunityPlayCount")
	COMMUNITY_PLAY_COUNT("CommunityPlayCount"),
	;

	/**
	 * Get the serial name of the enum member.
	 */
	public override fun toString(): String = serialName

	public companion object {
		/**
		 * Find the enum member by the serial name or return null.
		 */
		public fun fromNameOrNull(serialName: String): ChannelItemSortField? = when (serialName) {
			"Name" -> NAME
			"CommunityRating" -> COMMUNITY_RATING
			"PremiereDate" -> PREMIERE_DATE
			"DateCreated" -> DATE_CREATED
			"Runtime" -> RUNTIME
			"PlayCount" -> PLAY_COUNT
			"CommunityPlayCount" -> COMMUNITY_PLAY_COUNT
			else -> null
		}

		/**
		 * Find the enum member by the serial name or throw.
		 */
		public fun fromName(serialName: String): ChannelItemSortField =
				requireNotNull(fromNameOrNull(serialName)) { """Unknown value $serialName""" }
	}
}
