package io.wwdaigo.moviedb.movies.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.wwdaigo.data.MovieData
import io.wwdaigo.moviedb.R

/**
 * Created by daigomatsuoka on 15/07/17.
 */

class MoviesRecyclerViewAdapter(val observableList: Observable<List<MovieData>>): RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieViewHolder>() {

    var movieList: List<MovieData> = emptyList()

    init {
        observableList.observeOn(AndroidSchedulers.mainThread()).subscribe {
            this.movieList = it
            this.notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieViewHolder {

        val movieItemLayout = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.movie_list_card_item, parent, false)

        return MovieViewHolder(movieItemLayout)
    }

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {

        // Bind image view
        val movieNameTextView = holder!!.itemView.findViewById<TextView>(R.id.movie_name_text)

        movieNameTextView.text = movieList.get(position).title

    }


    inner class MovieViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}