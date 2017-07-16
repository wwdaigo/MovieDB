package io.wwdaigo.api.repository

import io.reactivex.Observable
import io.wwdaigo.api.response.Response
import io.wwdaigo.data.MovieData
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by daigomatsuoka on 15/07/17.
 */

interface MovieRequest {

    @GET("movie/popular")
    fun getMoviePopular(@Query("api_key") apiKey: String):Observable<Response<MovieData>>
}