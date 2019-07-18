package exercise.dicoding.maichel.dicodingmade.fragments

import android.content.Context
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import exercise.dicoding.maichel.dicodingmade.R
import exercise.dicoding.maichel.dicodingmade.adapter.FragmentMoviesAdapter
import exercise.dicoding.maichel.dicodingmade.api.ApiRepository
import exercise.dicoding.maichel.dicodingmade.api.FilmDBApi
import exercise.dicoding.maichel.dicodingmade.model.Films
import exercise.dicoding.maichel.dicodingmade.model.FilmsResponse
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_movies.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


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
    val requestFilmDBApi = FilmDBApi()
    val doRequest = ApiRepository()
    private lateinit var movie_adapter: FragmentMoviesAdapter
    private var list: List<Films> = ArrayList()
    private var gson = Gson()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        val x = doRequest.doRequest(requestFilmDBApi.getNowShowing())

        GlobalScope.async {
            val data = gson.fromJson(x.await(), FilmsResponse::class.java)
            movie_adapter = FragmentMoviesAdapter(data.results)

            view.rv_movies.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = movie_adapter
            }

            movie_adapter.notifyDataSetChanged()
        }

        return view
    }

//    class asyncData(val gson: Gson): AsyncTask<Void, Void, String>() {

//    }
}
