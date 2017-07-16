package io.wwdaigo.moviedb.viewmodels

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


    override val isLoading: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override val errorMessage: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}