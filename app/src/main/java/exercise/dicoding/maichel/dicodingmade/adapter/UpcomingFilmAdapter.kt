package exercise.dicoding.maichel.dicodingmade.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import exercise.dicoding.maichel.dicodingmade.DetailActivity
import exercise.dicoding.maichel.dicodingmade.model.ModelUpcomingFilm
import exercise.dicoding.maichel.dicodingmade.R
import exercise.dicoding.maichel.dicodingmade.fragments.FragmentMovies
import kotlinx.android.synthetic.main.item_movies.view.*

class UpcomingFilmAdapter(private val films: List<ModelUpcomingFilm>): RecyclerView.Adapter<UpcomingFilmAdapter.FilmHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        return FilmHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))
    }

    override fun getItemCount(): Int = films.size

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder.bindFilm(films[position])
    }

    class FilmHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val tvFilmName = itemView.tv_up_film_name
        private var imgFilm = itemView.img_up_film

        fun bindFilm(film: ModelUpcomingFilm) = with(itemView){

            tvFilmName.text = film.title
            Picasso.get()
                .load(film.img_source)
                .into(imgFilm)
        }
    }
}

