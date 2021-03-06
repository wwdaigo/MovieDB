package io.wwdaigo.moviedb.features.movies.viewmodels

import android.content.Context
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.wwdaigo.api.manager.MovieManager
import io.wwdaigo.data.MovieData
import io.wwdaigo.moviedb.R
import io.wwdaigo.moviedb.viewmodel.ViewModel
import io.wwdaigo.moviedb.viewmodel.ViewModelOutputs

/**
 * Created by daigomatsuoka on 15/07/17.
 */

interface MainViewModelInputs {
    fun getPopular()
    fun getTopRated()
}

interface MainViewModelOutputs: ViewModelOutputs {
    val movieList: Observable<List<MovieData>>
}

interface MainViewModelType {
    val inputs: MainViewModelInputs
    val outputs: MainViewModelOutputs
}

class MainViewModel(val context: Context): ViewModel(), MainViewModelType, MainViewModelInputs, MainViewModelOutputs {

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

    override fun getTopRated() {
        screenTitlePublish.onNext(context.getString(R.string.top_rated_movies))
        isLoadingPublish.onNext(true)
        movieManager.getTopRated()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    movieListPublish.onNext(it.results)
                    isLoadingPublish.onNext(false)
                }
    }

    override fun getPopular() {

        screenTitlePublish.onNext(context.getString(R.string.popular_movies))
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