package com.gonzalezblanchard.marvelheroes.utils

import com.google.gson.*
import java.lang.reflect.Type


private val TRUE_STRINGS: Array<String> = arrayOf("true", "1")

class BooleanObjectTypeAdapter : JsonDeserializer<Boolean?>, JsonSerializer<Boolean?> {

    override fun serialize(src: Boolean?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return if (src == null) {
            JsonNull.INSTANCE
        } else {
            JsonPrimitive(src)
        }
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Boolean? {
        if (json == null || json.isJsonNull) {
            return null
        }

        return when {
            json !is JsonPrimitive -> false
            json.isBoolean -> json.asBoolean
            json.isNumber -> json.asNumber.toInt() == 1
            json.isString -> TRUE_STRINGS.contains(json.asString.lowercase())
            else -> false
        }
    }
}