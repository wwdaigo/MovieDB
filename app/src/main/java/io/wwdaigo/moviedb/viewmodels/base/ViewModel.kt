package io.wwdaigo.moviedb.viewmodels.base

/**
 * Created by daigomatsuoka on 15/07/17.
 */

interface ViewModel {

    interface Outputs {
        val isLoading: Boolean
        val errorMessage: String
    }

}