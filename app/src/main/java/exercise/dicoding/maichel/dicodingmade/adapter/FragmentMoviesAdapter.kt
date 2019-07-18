package exercise.dicoding.maichel.dicodingmade.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import exercise.dicoding.maichel.dicodingmade.BuildConfig
import exercise.dicoding.maichel.dicodingmade.R
import exercise.dicoding.maichel.dicodingmade.model.Films
import kotlinx.android.synthetic.main.item_movies.view.*

class FragmentMoviesAdapter(private val movies_show: List<Films>): RecyclerView.Adapter<FragmentMoviesAdapter.moviesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): moviesHolder {
        return moviesHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))
    }

    override fun getItemCount(): Int = movies_show.size

    override fun onBindViewHolder(holder: moviesHolder, position: Int) {
        holder.bindMovies(movies_show[position])
    }

    class moviesHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val tv_title = itemView.tv_up_film_name
        private val img_movie = itemView.img_up_film

        fun bindMovies(movies: Films){
            tv_title.text = movies.original_title
            Picasso.get()
                .load(BuildConfig.IMAGE_URL+movies.poster_path)
                .into(img_movie)
        }
    }
}