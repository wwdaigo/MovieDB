package io.wwdaigo.moviedb.features.detail.viewmodels

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.wwdaigo.moviedb.viewmodel.ViewModel
import io.wwdaigo.moviedb.viewmodel.ViewModelOutputs

/**
 * Created by daigomatsuoka on 16/07/17.
 */
interface MovieDetailViewModelInputs {

}

interface MovieDetailViewModelOutputs: ViewModelOutputs {

}

interface MovieDetailViewModelType {
    val inputs: MovieDetailViewModelInputs
    val outputs: MovieDetailViewModelOutputs
}

class MovieDetailViewModel: ViewModel(), MovieDetailViewModelType, MovieDetailViewModelInputs, MovieDetailViewModelOutputs {

    override val inputs: MovieDetailViewModelInputs
        get() = this

    override val outputs: MovieDetailViewModelOutputs
        get() = this


}