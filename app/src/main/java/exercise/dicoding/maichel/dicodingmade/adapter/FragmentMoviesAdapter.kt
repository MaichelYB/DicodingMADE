package exercise.dicoding.maichel.dicodingmade.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import exercise.dicoding.maichel.dicodingmade.BuildConfig
import exercise.dicoding.maichel.dicodingmade.DetailActivity
import exercise.dicoding.maichel.dicodingmade.R
import exercise.dicoding.maichel.dicodingmade.model.Films
import exercise.dicoding.maichel.dicodingmade.model.ResultFilm
import kotlinx.android.synthetic.main.item_movies.view.*

class FragmentMoviesAdapter(private val movies_show: ArrayList<Films>, val context: Context, val listener: (Films)->Unit): RecyclerView.Adapter<FragmentMoviesAdapter.moviesHolder>() {
    var intent:Intent? = null
    var movies:ArrayList<Films>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): moviesHolder {
        return moviesHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false))
    }

    override fun getItemCount(): Int = movies_show.size

    override fun onBindViewHolder(holder: moviesHolder, position: Int) {
        holder.bindMovies(movies_show[position], listener)

        holder.mcardView.setOnClickListener {
            var mov:Films = movies_show.get(position)
            intent = Intent(context, DetailActivity::class.java)
            intent!!.putExtra("data", mov)
            context.startActivity(intent)
        }
    }

    class moviesHolder(view: View):RecyclerView.ViewHolder(view) {
        private val tv_title = view.tv_up_film_name
        private val img_movie = view.img_up_film
        var     mcardView = view.cv_movies

        fun bindMovies(movies: Films, listener: (Films) -> Unit){
            mcardView.setOnClickListener { listener(movies) }
            if(movies.name != null && movies.original_title == null){
                tv_title.text = movies.name
            }else{
                tv_title.text = movies.original_title
            }
            Picasso.get()
                .load(BuildConfig.IMAGE_URL+movies.poster_path)
                .into(img_movie)
        }
    }
}