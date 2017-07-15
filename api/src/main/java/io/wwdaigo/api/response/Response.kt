package io.wwdaigo.api.response

/**
 * Created by daigomatsuoka on 15/07/17.
 */
data class Response<T>(
        val id: Int,
        val results: List<T>
)