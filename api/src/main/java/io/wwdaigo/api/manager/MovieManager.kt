package io.wwdaigo.api.manager

import io.reactivex.Observable
import io.wwdaigo.api.RestApi
import io.wwdaigo.api.commons.API_KEY
import io.wwdaigo.api.response.Response
import io.wwdaigo.data.MovieData
import io.wwdaigo.data.ReviewData
import io.wwdaigo.data.VideoData

/**
 * Created by daigomatsuoka on 15/07/17.
 */

class MovieManager {
    fun getPopular():Observable<Response<MovieData>> {
        return RestApi().movieRequest.getMoviePopular(API_KEY)
    }

    fun getTopRated():Observable<Response<MovieData>> {
        return RestApi().movieRequest.getMovieTopRated(API_KEY)
    }

    fun getVideos(movieId: Int): Observable<Response<VideoData>> {
        return RestApi().movieRequest.getMovieVideos(API_KEY, movieId)
    }

    fun getReviews(movieId: Int): Observable<Response<ReviewData>> {
        return RestApi().movieRequest.getMovieReviews(API_KEY, movieId)
    }
}