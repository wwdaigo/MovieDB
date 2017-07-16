package io.wwdaigo.moviedb.router

import android.content.Context
import io.wwdaigo.data.MovieData
import io.wwdaigo.moviedb.features.detail.activities.MovieDetailActivity

/**
 * Created by daigomatsuoka on 16/07/17.
 */
interface MainRouterType {
    fun goToDetails(data: MovieData)
}

class MainRouter(val context: Context): MainRouterType {

    override fun goToDetails(data: MovieData) {
        MovieDetailActivity.start(context, data)
    }
}