package io.wwdaigo.moviedb.movies.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import io.wwdaigo.moviedb.R
import io.wwdaigo.moviedb.movies.viewmodels.MainViewModel
import io.wwdaigo.moviedb.movies.viewmodels.MainViewModelType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModelType by lazy { MainViewModel() }

    /*
    val moviesRecyclerView: RecyclerView by lazy {

        movies_recycler_view
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        movies_recycler_view.setHasFixedSize(true)
        movies_recycler_view.layoutManager = LinearLayoutManager(this)
    }
}