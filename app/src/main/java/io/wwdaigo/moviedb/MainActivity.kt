package io.wwdaigo.moviedb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import io.wwdaigo.api.manager.MovieManager
import io.wwdaigo.moviedb.viewmodels.MainViewModel
import io.wwdaigo.moviedb.viewmodels.MainViewModelType

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModelType by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MovieManager().getPopular()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    print(it)
                }
    }
}
