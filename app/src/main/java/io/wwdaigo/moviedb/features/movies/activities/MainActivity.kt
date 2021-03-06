package io.wwdaigo.moviedb.features.movies.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import io.wwdaigo.data.MovieData

import io.wwdaigo.moviedb.R
import io.wwdaigo.moviedb.features.movies.adapters.MoviesRecyclerViewAdapter
import io.wwdaigo.moviedb.features.movies.adapters.OnViewSelectedItem
import io.wwdaigo.moviedb.features.movies.viewmodels.MainViewModel
import io.wwdaigo.moviedb.features.movies.viewmodels.MainViewModelType
import io.wwdaigo.moviedb.router.MainRouter
import io.wwdaigo.moviedb.router.MainRouterType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnViewSelectedItem {

    val viewModel: MainViewModelType by lazy { MainViewModel(this) }
    val router: MainRouterType by lazy { MainRouter(this) }

    val progressBar by lazy { progress }
    val moviesRecyclerView: RecyclerView by lazy {
        movies_recycler_view.setHasFixedSize(true)
        movies_recycler_view.layoutManager = LinearLayoutManager(this)
        movies_recycler_view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesAdapter = MoviesRecyclerViewAdapter(this, viewModel.outputs.movieList)
        moviesRecyclerView.adapter = moviesAdapter

    }

    override fun onStart() {
        super.onStart()
        bindOuputs()

        viewModel.inputs.getPopular()
    }

    fun bindOuputs() = with(viewModel.outputs) {
        isLoading.subscribe {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        screenTitle.subscribe {
            title = it
        }
    }

    override fun onItemSelected(data: MovieData) {
        router.goToDetails(data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu!!)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {

            R.id.menu_main_popular -> {
                viewModel.inputs.getPopular()
                return true
            }

            R.id.menu_main_top_rated -> {
                viewModel.inputs.getTopRated()
                return true
            }

            else -> return super.onOptionsItemSelected(item)

        }
    }
}
