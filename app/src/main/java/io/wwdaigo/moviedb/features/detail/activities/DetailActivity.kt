package io.wwdaigo.moviedb.features.detail.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import io.wwdaigo.data.MovieData

import io.wwdaigo.moviedb.R
import io.wwdaigo.moviedb.commons.enums.IntentExtra

class DetailActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context, data: MovieData) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(IntentExtra.MOVIE_DATA.key, data)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener(View.OnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        })
    }
}
