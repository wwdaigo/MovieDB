package io.wwdaigo.moviedb.viewmodels

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.wwdaigo.moviedb.viewmodels.base.ViewModel

/**
 * Created by daigomatsuoka on 15/07/17.
 */

interface MainViewModelInputs {

}

interface MainViewModelOutputs: ViewModel.Outputs {

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
}