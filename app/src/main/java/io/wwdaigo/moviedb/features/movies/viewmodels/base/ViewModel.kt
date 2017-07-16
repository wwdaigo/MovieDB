package io.wwdaigo.moviedb.features.movies.viewmodels.base

import io.reactivex.Observable

/**
 * Created by daigomatsuoka on 15/07/17.
 */

interface ViewModel {

    interface Outputs {
        val isLoading: Observable<Boolean>
        val errorMessage: Observable<String>
    }

}