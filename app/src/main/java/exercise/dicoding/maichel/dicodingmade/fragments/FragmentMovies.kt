package exercise.dicoding.maichel.dicodingmade.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import exercise.dicoding.maichel.dicodingmade.BuildConfig
import exercise.dicoding.maichel.dicodingmade.DetailActivity
import exercise.dicoding.maichel.dicodingmade.R
import exercise.dicoding.maichel.dicodingmade.adapter.FragmentMoviesAdapter
import exercise.dicoding.maichel.dicodingmade.model.Films
import exercise.dicoding.maichel.dicodingmade.model.ResultFilm
import exercise.dicoding.maichel.dicodingmade.util.FilmService
import kotlinx.android.synthetic.main.item_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.widget.Toast
import exercise.dicoding.maichel.dicodingmade.MainActivity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.os.Parcelable
import kotlinx.android.synthetic.main.fragment_movies.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragment_movies.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragment_movies.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FragmentMovies : Fragment() {
    private var data:ArrayList<Films>? = null
    private lateinit var filmAdapter: FragmentMoviesAdapter
    private lateinit var cv_movies: CardView
    private var savedRecyclerLayoutState: Parcelable? = null
    private var moviesInstance:ArrayList<Films>? = null
    private lateinit var recyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movies, container, false)

        val progressBar:ProgressBar = view.findViewById(R.id.pb_movies)
        recyclerView = view.findViewById(R.id.rv_movies)
//        cv_movies = view.findViewById(R.id.cv_movies)

        progressBar.visibility = View.VISIBLE

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(FilmService::class.java)
        service.getFilm().enqueue(object : Callback<ResultFilm> {
            override fun onFailure(call: Call<ResultFilm>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

            override fun onResponse(call: Call<ResultFilm>, response: Response<ResultFilm>) {
                data = response.body()?.results
//                Log.d("HAHA", data.get(recyclerView.indexOfChild(view)).original_title.toString())
                Log.d("HAHA", data.toString())

                progressBar.visibility = View.GONE

                filmAdapter = FragmentMoviesAdapter(data!!, activity!!){

                }

                recyclerView.apply {
                    layoutManager = LinearLayoutManager(activity!!)
                    adapter = filmAdapter
                }
            }

        })
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        moviesInstance = data

        if(moviesInstance!=null){
            outState.putParcelableArrayList("films", moviesInstance)
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        data = savedInstanceState?.getParcelableArrayList("films")
        if(data != null){
            pb_movies.visibility = View.GONE
            filmAdapter = FragmentMoviesAdapter(savedInstanceState?.getParcelableArrayList("films")!!, activity!!){

            }
            recyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = filmAdapter
            }
        }
    }
}
