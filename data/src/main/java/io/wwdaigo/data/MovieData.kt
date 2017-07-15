package io.wwdaigo.data

import com.google.gson.annotations.SerializedName

/**
 * Created by daigomatsuoka on 15/07/17.
 */
data class MovieData(
        val id: Int,
        val name: String,
        val description: String,

        @SerializedName("favorite_count")
        val favoriteCount: Int,

        @SerializedName("item_count")
        val itemCount: Int,

        @SerializedName("list_type")
        val listType: String,

        @SerializedName("poster_path")
        val posterPath: String
)