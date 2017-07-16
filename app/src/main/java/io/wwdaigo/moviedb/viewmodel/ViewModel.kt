package io.wwdaigo.moviedb.viewmodel

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by daigomatsuoka on 15/07/17.
 */

interface ViewModelOutputs {
    val isLoading: Observable<Boolean>
    val errorMessage: Observable<String>
    val title: Observable<String>
}

abstract class ViewModel: ViewModelOutputs {

    val isLoadingPublish = PublishSubject.create<Boolean>()
    override val isLoading: Observable<Boolean>
        get() = isLoadingPublish

    val errorMessagePublish = PublishSubject.create<String>()
    override val errorMessage: Observable<String>
        get() = errorMessagePublish

    val titlePublish = PublishSubject.create<String>()
    override val title: Observable<String>
        get() = titlePublish

}