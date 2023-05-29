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
public enum class RecordingStatus(
	public val serialName: String,
) {
	@SerialName("New")
	NEW("New"),
	@SerialName("InProgress")
	IN_PROGRESS("InProgress"),
	@SerialName("Completed")
	COMPLETED("Completed"),
	@SerialName("Cancelled")
	CANCELLED("Cancelled"),
	@SerialName("ConflictedOk")
	CONFLICTED_OK("ConflictedOk"),
	@SerialName("ConflictedNotOk")
	CONFLICTED_NOT_OK("ConflictedNotOk"),
	@SerialName("Error")
	ERROR("Error"),
	;

	/**
	 * Get the serial name of the enum member.
	 */
	override fun toString(): String = serialName

	public companion object {
		/**
		 * Find the enum member by the serial name or return null.
		 */
		public fun fromNameOrNull(serialName: String): RecordingStatus? = when (serialName) {
			"New" -> NEW
			"InProgress" -> IN_PROGRESS
			"Completed" -> COMPLETED
			"Cancelled" -> CANCELLED
			"ConflictedOk" -> CONFLICTED_OK
			"ConflictedNotOk" -> CONFLICTED_NOT_OK
			"Error" -> ERROR
			else -> null
		}

		/**
		 * Find the enum member by the serial name or throw.
		 */
		public fun fromName(serialName: String): RecordingStatus =
				requireNotNull(fromNameOrNull(serialName)) { """Unknown value $serialName""" }
	}
}
