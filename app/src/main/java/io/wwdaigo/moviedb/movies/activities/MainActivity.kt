package io.wwdaigo.moviedb.movies.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import io.wwdaigo.moviedb.R
import io.wwdaigo.moviedb.movies.adapters.MoviesRecyclerViewAdapter
import io.wwdaigo.moviedb.movies.viewmodels.MainViewModel
import io.wwdaigo.moviedb.movies.viewmodels.MainViewModelType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModelType by lazy { MainViewModel() }

    val progressBar by lazy { progress }

    val moviesRecyclerView: RecyclerView by lazy {

        movies_recycler_view.setHasFixedSize(true)
        movies_recycler_view.layoutManager = LinearLayoutManager(this)
        movies_recycler_view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesAdapter = MoviesRecyclerViewAdapter(viewModel.outputs.movieList)
        moviesRecyclerView.adapter = moviesAdapter
    }

    override fun onStart() {
        super.onStart()
        bindOuputs()

        viewModel.inputs.getPopular()
    }

    fun bindOuputs() {
        viewModel.outputs.isLoading.subscribe {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

    }
}
