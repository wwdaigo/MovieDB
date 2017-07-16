package io.wwdaigo.moviedb.features.detail.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.wwdaigo.data.MovieData

import io.wwdaigo.moviedb.R
import io.wwdaigo.moviedb.commons.IntentExtras

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context, data: MovieData) {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(IntentExtras.MOVIE_DATA.key, data)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
    }
}
