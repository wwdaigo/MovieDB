package io.wwdaigo.data

import com.google.gson.annotations.SerializedName

/**
 * Created by daigomatsuoka on 15/07/17.
 */
const val IMAGE_URL = "http://image.tmdb.org/t/p/"
const val COVER_WIDTH = "w780"

data class MovieData(
        val id: Int,
        val title: String,

        @SerializedName("original_title")
        val originalTitle: String,
        val overview: String,
        val adult: Boolean,

        @SerializedName("release_date")
        val releaseDate: String,

        @SerializedName("original_language")
        val originalLanguage: String,

        @SerializedName("vote_count")
        val voteCount: Int,

        @SerializedName("poster_path")
        val posterPath: String,

        @SerializedName("backdrop_path")
        val backdropPath: String,

        val popularity: Float,
        val video: Boolean,

        @SerializedName("vote_average")
        val voteAverage: Float,

        @SerializedName("genre_ids")
        val genreIds:List<Int>
) {
        val backDropUrl: String
                get() = "$IMAGE_URL$COVER_WIDTH$backdropPath"
}