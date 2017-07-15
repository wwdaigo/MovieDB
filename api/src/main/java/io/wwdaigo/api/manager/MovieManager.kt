package io.wwdaigo.api.manager

import io.reactivex.Observable
import io.wwdaigo.api.RestApi
import io.wwdaigo.api.commons.API_KEY
import io.wwdaigo.api.response.Response
import io.wwdaigo.data.MovieData

/**
 * Created by daigomatsuoka on 15/07/17.
 */

class MovieManager {
    fun getPopular():Observable<Response<MovieData>> {
        return RestApi().movieRequest.getMoviePopular(API_KEY)
    }
}