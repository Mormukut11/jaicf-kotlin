package com.justai.jaicf.channel.jaicp.dto

import com.justai.jaicf.api.BotRequest
import com.justai.jaicf.api.BotRequestType
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.content

@Serializable
data class JaicpBotRequest(
    val data: JsonElement,
    val version: Int,
    val botId: String,
    val channelType: String,
    val channelBotId: String,
    val channelUserId: String,
    val questionId: String,
    val query: String? = null,
    val rawRequest: JsonObject,
    val userFrom: JsonElement,
    val event: String? = null
) : BotRequest {
    override val type: BotRequestType = if (query != null) BotRequestType.QUERY else BotRequestType.EVENT
    override val clientId = channelUserId
    override val input: String = query ?: event ?: ""
}