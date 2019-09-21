package exercise.dicoding.maichel.dicodingmade

import android.content.Intent
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import exercise.dicoding.maichel.dicodingmade.adapter.FragmentMoviesAdapter
import exercise.dicoding.maichel.dicodingmade.model.*
import exercise.dicoding.maichel.dicodingmade.util.CastingService
import exercise.dicoding.maichel.dicodingmade.util.CastingTVService
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivity: AppCompatActivity() {

    var i:String? = null
    var films: Films? = null
    var data:ArrayList<Casting>? = null
    var caster:String? = null
    var title:String?=null
    var overview:String? = null
    var status:String? = null
    var image: Image? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        pb_movies.visibility = View.VISIBLE

//        val item = intent.getParcelableExtra<Films>("data")
        films = intent.getParcelableExtra("data")

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CastingService::class.java)
        val tvService = retrofit.create(CastingTVService::class.java)

        Log.d("FILMS", films?.id.toString())

        if(films?.original_title == null){
            tvService.getTvCasting(films?.id.toString()).enqueue(object : Callback<Cast>{

                override fun onFailure(call: Call<Cast>, t: Throwable) {
                    Log.d("Error", t.message.toString())
                }

                override fun onResponse(call: Call<Cast>, response: Response<Cast>) {
                    data = response.body()!!.cast

                    for (i in 0..data!!.size.minus(1)){

                        if(i == 0){
                            caster = data!!.get(i).name
                        }
                        else{
                            caster += data!!.get(i).name
                        }

                        if(i < data!!.size){
                            caster += "\n"
                        }
                    }

                    Picasso.get()
                        .load(BuildConfig.IMAGE_URL+films?.poster_path.toString())
                        .into(img_up_film_detail)

                    title_up_film_detail.text = films?.name
                    tanggal_tayang.text = films?.release_date
                    act_up_movie_detail.text = caster
                    title = films?.name
                    overview = films?.overview

                    if(films?.overview!=""){
                        synopsis_up_movies.text = films?.overview
                        stat_up_movies.text = "Upcoming"
                        status = "Upcoming"
                    }else{
                        synopsis_up_movies.text = ""
                        stat_up_movies.text = "OnGoing"
                        status = "OnGoing"
                    }

                    pb_movies.visibility = View.GONE
                }
            })
        }else{
            service.getFilmsCasting(films?.id.toString()).enqueue(object : Callback<Cast>{
                override fun onFailure(call: Call<Cast>, t: Throwable) {
                    Log.d("Error", t.message.toString())
                }

                override fun onResponse(call: Call<Cast>, response: Response<Cast>) {
                    data = response.body()!!.cast

                    for (i in 0..data!!.size.minus(1)){

                        if(i == 0){
                            caster = data!!.get(i).name
                        }
                        else{
                            caster += data!!.get(i).name
                        }

                        if(i < data!!.size){
                            caster += "\n"
                        }
                    }

                    Picasso.get()
                        .load(BuildConfig.IMAGE_URL+films?.poster_path.toString())
                        .into(img_up_film_detail)

                    title_up_film_detail.text = films?.original_title
                    tanggal_tayang.text = films?.release_date
                    act_up_movie_detail.text = caster
                    title = films?.original_title
                    overview = films?.overview

                    if(films?.overview!=""){
                        synopsis_up_movies.text = films?.overview
                        stat_up_movies.text = "Upcoming"
                        status = "Upcoming"
                    }else{
                        synopsis_up_movies.text = ""
                        stat_up_movies.text = "OnGoing"
                        status = "Ongoing"
                    }

                    pb_movies.visibility = View.GONE
                }
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.localization_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_change_settings){
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("caster", act_up_movie_detail.text.toString())
        outState.putString("title", title_up_film_detail.text.toString())
        outState.putString("status", stat_up_movies.text.toString())
        outState.putString("tanggal", tanggal_tayang.text.toString())
        outState.putString("overview", synopsis_up_movies.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        act_up_movie_detail.text = savedInstanceState.getString("caster")
        title_up_film_detail.text = savedInstanceState.getString("title")
        stat_up_movies.text = savedInstanceState.getString("status")
        tanggal_tayang.text = savedInstanceState.getString("tanggal")
        synopsis_up_movies.text = savedInstanceState.getString("overview")
    }
}