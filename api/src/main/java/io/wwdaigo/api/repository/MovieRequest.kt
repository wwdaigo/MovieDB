package io.wwdaigo.api.repository

import io.reactivex.Observable
import io.wwdaigo.api.response.Response
import io.wwdaigo.data.MovieData
import io.wwdaigo.data.ReviewData
import io.wwdaigo.data.VideoData
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by daigomatsuoka on 15/07/17.
 */

interface MovieRequest {

    @GET("/movie/popular")
    fun getMoviePopular(@Query("api_key") apiKey: String):Observable<Response<MovieData>>

    @GET("/movie/top_rated")
    fun getMovieTopRated(@Query("api_key") apiKey: String):Observable<Response<MovieData>>

    @GET("movie/{movie_id}/videos")
    fun getMovieVideos(@Query("api_key") apiKey: String,
                       @Query("movie_id") movieId: Int): Observable<Response<VideoData>>

    @GET("movie/{movie_id}/reviews")
    fun getMovieReviews(@Query("api_key") apiKey: String,
                       @Query("movie_id") movieId: Int): Observable<Response<ReviewData>>
}