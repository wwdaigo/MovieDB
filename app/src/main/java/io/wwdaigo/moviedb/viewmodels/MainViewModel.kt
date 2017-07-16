package io.wwdaigo.moviedb.viewmodels

/**
 * Created by daigomatsuoka on 15/07/17.
 */

interface MainViewModelInputs {

}

interface MainViewModelOutputs {

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

    
}