package exercise.dicoding.maichel.dicodingmade

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import exercise.dicoding.maichel.dicodingmade.Model.ModelUpcomingFilm
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getParcelableExtra<ModelUpcomingFilm>("item")
        Log.d("HA", item.img_source)

        Picasso.get()
            .load(item.img_source)
            .into(img_up_film_detail)

        title_up_film_detail.text = item.title
        director_up_movie_detail.text = item.directors
        stat_up_movies.text = item.status
        act_up_movie_detail.text = item.actors
        synopsis_up_movies.text = item.synopsis
    }
}