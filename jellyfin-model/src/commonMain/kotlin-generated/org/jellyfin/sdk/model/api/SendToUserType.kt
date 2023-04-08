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
public enum class SendToUserType(
	public val serialName: String,
) {
	@SerialName("All")
	ALL("All"),
	@SerialName("Admins")
	ADMINS("Admins"),
	@SerialName("Custom")
	CUSTOM("Custom"),
	;

	/**
	 * Get the serial name of the enum member.
	 */
	public override fun toString(): String = serialName

	public companion object {
		/**
		 * Find the enum member by the serial name or return null.
		 */
		public fun fromNameOrNull(serialName: String): SendToUserType? = when (serialName) {
			"All" -> ALL
			"Admins" -> ADMINS
			"Custom" -> CUSTOM
			else -> null
		}

		/**
		 * Find the enum member by the serial name or throw.
		 */
		public fun fromName(serialName: String): SendToUserType =
				requireNotNull(fromNameOrNull(serialName)) { """Unknown value $serialName""" }
	}
}
