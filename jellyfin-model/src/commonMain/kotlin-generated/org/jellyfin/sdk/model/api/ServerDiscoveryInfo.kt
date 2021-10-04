// !!        WARNING
// !! DO NOT EDIT THIS FILE
//
// This file is generated by the openapi-generator module and is not meant for manual changes.
// Please read the README.md file in the openapi-generator module for additional information.
package org.jellyfin.sdk.model.api

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ServerDiscoveryInfo(
	/**
	 * Gets or sets the address.
	 */
	@SerialName("Address")
	public val address: String? = null,
	/**
	 * Gets or sets the server identifier.
	 */
	@SerialName("Id")
	public val id: String? = null,
	/**
	 * Gets or sets the name.
	 */
	@SerialName("Name")
	public val name: String? = null,
	/**
	 * Gets or sets the endpoint address.
	 */
	@SerialName("EndpointAddress")
	public val endpointAddress: String? = null
)