package exercise.dicoding.maichel.dicodingmade.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import exercise.dicoding.maichel.dicodingmade.model.ModelUpcomingFilm
import exercise.dicoding.maichel.dicodingmade.R
import kotlinx.android.synthetic.main.item_upcoming_shows.view.*

class UpcomingFilmAdapter(private val films: List<ModelUpcomingFilm>, val listener: (ModelUpcomingFilm)->Unit): RecyclerView.Adapter<UpcomingFilmAdapter.FilmHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        return FilmHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_upcoming_shows, parent, false))
    }

    override fun getItemCount(): Int = films.size

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder.bindFilm(films[position], listener)
    }

    class FilmHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val tvFilmName = itemView.tv_up_film_name
        private var imgFilm = itemView.img_up_film

        fun bindFilm(film: ModelUpcomingFilm, listener: (ModelUpcomingFilm) -> Unit) = with(itemView){
            setOnClickListener { listener(film) }
            tvFilmName.text = film.title
            Picasso.get()
                .load(film.img_source)
                .into(imgFilm)
        }
    }
}

