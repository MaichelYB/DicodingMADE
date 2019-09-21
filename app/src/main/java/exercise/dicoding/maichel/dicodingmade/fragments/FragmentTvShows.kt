package exercise.dicoding.maichel.dicodingmade.fragments


import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.IntegerRes
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import exercise.dicoding.maichel.dicodingmade.BuildConfig
import exercise.dicoding.maichel.dicodingmade.R
import exercise.dicoding.maichel.dicodingmade.adapter.FragmentMoviesAdapter
import exercise.dicoding.maichel.dicodingmade.model.Films
import exercise.dicoding.maichel.dicodingmade.model.ResultFilm
import exercise.dicoding.maichel.dicodingmade.util.FilmService
import exercise.dicoding.maichel.dicodingmade.util.UpcomingFilmService
import kotlinx.android.synthetic.main.fragment_tv_show.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentTvShows : Fragment() {
    private var data:ArrayList<Films>? = null
    private lateinit var filmAdapter: FragmentMoviesAdapter
    private var moviesInstance:ArrayList<Films>? = null
    private lateinit var recyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tv_show, container, false)
        recyclerView = view.findViewById(R.id.rv_tv_shows)
        val progressBar: ProgressBar = view.findViewById(R.id.pb_movies)

        progressBar.visibility = View.VISIBLE

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(UpcomingFilmService::class.java)
        service.getUpcomingFilm().enqueue(object : Callback<ResultFilm> {
            override fun onFailure(call: Call<ResultFilm>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

            override fun onResponse(call: Call<ResultFilm>, response: Response<ResultFilm>) {
                data = response.body()?.results
//                Log.d("HAHA", data!!.get(0).original_title.toString())

                val filmAdapter = FragmentMoviesAdapter(data!!, activity!!){

                }
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = filmAdapter
                }
                progressBar.visibility = View.GONE
            }

        })
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        moviesInstance = data
        Log.e("DATAA", moviesInstance.toString())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        moviesInstance = data
        Log.e("DATAAA", moviesInstance.toString())
        if(moviesInstance!=null){
            outState.putParcelableArrayList("films", moviesInstance)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("SAVED", savedInstanceState.toString())

        data = savedInstanceState?.getParcelableArrayList("films")
        if(data!=null){
            pb_movies.visibility = View.GONE
            filmAdapter = FragmentMoviesAdapter(savedInstanceState?.getParcelableArrayList("films")!!, activity!!){

            }
            recyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = filmAdapter
            }
        }else{

        }
    }
}
