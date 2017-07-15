package io.wwdaigo.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by daigomatsuoka on 15/07/17.
 */
data class Response<T>(
        val id: Int,
        val page: Int,
        @SerializedName("total_pages")
        val totalPages: Int,
        @SerializedName("total_results")
        val totalResults: Int,
        val results: List<T>
)