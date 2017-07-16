package io.wwdaigo.moviedb.features.movies.adapters

import io.wwdaigo.data.MovieData

/**
 * Created by daigomatsuoka on 16/07/17.
 */

interface OnViewSelectedItem {
    fun onItemSelected(data: MovieData)
}