package io.wwdaigo.moviedb.features.detail.viewmodels

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.wwdaigo.moviedb.features.movies.viewmodels.base.ViewModel

/**
 * Created by daigomatsuoka on 16/07/17.
 */
interface MovieDetailViewModelInputs {

}

interface MovieDetailViewModelOutputs: ViewModel.Outputs {

}

interface MovieDetailViewModelType {
    val inputs: MovieDetailViewModelInputs
    val outputs: MovieDetailViewModelOutputs
}

class MovieDetailViewModel: MovieDetailViewModelType, MovieDetailViewModelInputs, MovieDetailViewModelOutputs {

    override val inputs: MovieDetailViewModelInputs
        get() = this

    override val outputs: MovieDetailViewModelOutputs
        get() = this

    val isLoadingPublish = PublishSubject.create<Boolean>()
    override val isLoading: Observable<Boolean>
        get() = isLoadingPublish

    val errorMessagePublish = PublishSubject.create<String>()
    override val errorMessage: Observable<String>
        get() = errorMessagePublish
}