package io.wwdaigo.moviedb.viewmodels

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.wwdaigo.api.manager.MovieManager
import io.wwdaigo.data.MovieData
import io.wwdaigo.moviedb.viewmodels.base.ViewModel

/**
 * Created by daigomatsuoka on 15/07/17.
 */

interface MainViewModelInputs {
    fun getPopular()
}

interface MainViewModelOutputs: ViewModel.Outputs {
    val movieList: Observable<List<MovieData>>
}

interface MainViewModelType {
    val inputs: MainViewModelInputs
    val outputs: MainViewModelOutputs
}

class MainViewModel: MainViewModelType, MainViewModelInputs, MainViewModelOutputs {

    override val inputs: MainViewModelInputs
        get() = this

    override val outputs: MainViewModelOutputs
        get() = this


    val isLoadingPublish = PublishSubject.create<Boolean>()
    override val isLoading: Observable<Boolean>
        get() = isLoadingPublish

    val errorMessagePublish = PublishSubject.create<String>()
    override val errorMessage: Observable<String>
        get() = errorMessagePublish

    val movieListPublish = PublishSubject.create<List<MovieData>>()
    override val movieList: Observable<List<MovieData>>
        get() = movieListPublish


    val movieManager by lazy {
        MovieManager()
    }


    override fun getPopular() {

        movieManager.getPopular()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    movieListPublish.onNext(it.results)
                }
    }
}