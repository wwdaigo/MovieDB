package io.wwdaigo.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by daigomatsuoka on 15/07/17.
 */
data class ErrorData(
        @SerializedName("status_message")
        val statusMessage: String,

        @SerializedName("status_code")
        val statusCode: Int
)