package io.wwdaigo.moviedb.features.movies.viewmodels

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.wwdaigo.api.manager.MovieManager
import io.wwdaigo.data.MovieData
import io.wwdaigo.moviedb.viewmodel.ViewModel
import io.wwdaigo.moviedb.viewmodel.ViewModelOutputs

/**
 * Created by daigomatsuoka on 15/07/17.
 */

interface MainViewModelInputs {
    fun getPopular()
}

interface MainViewModelOutputs: ViewModelOutputs {
    val movieList: Observable<List<MovieData>>
}

interface MainViewModelType {
    val inputs: MainViewModelInputs
    val outputs: MainViewModelOutputs
}

class MainViewModel: ViewModel(), MainViewModelType, MainViewModelInputs, MainViewModelOutputs {

    override val inputs: MainViewModelInputs
        get() = this

    override val outputs: MainViewModelOutputs
        get() = this

    val movieListPublish = PublishSubject.create<List<MovieData>>()
    override val movieList: Observable<List<MovieData>>
        get() = movieListPublish


    val movieManager by lazy {
        MovieManager()
    }

    override fun getPopular() {

        isLoadingPublish.onNext(true)
        movieManager.getPopular()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    movieListPublish.onNext(it.results)
                    isLoadingPublish.onNext(false)
                }
    }
}