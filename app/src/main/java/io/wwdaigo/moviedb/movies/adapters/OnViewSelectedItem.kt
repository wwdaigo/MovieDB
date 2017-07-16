package io.wwdaigo.moviedb.movies.adapters

import io.wwdaigo.data.MovieData

/**
 * Created by daigomatsuoka on 16/07/17.
 */

interface OnViewSelectedItem {
    fun onItemSelected(data: MovieData)
}