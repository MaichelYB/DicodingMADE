package exercise.dicoding.maichel.dicodingmade.util

import exercise.dicoding.maichel.dicodingmade.BuildConfig
import exercise.dicoding.maichel.dicodingmade.model.Cast
import exercise.dicoding.maichel.dicodingmade.model.Casting
import exercise.dicoding.maichel.dicodingmade.model.Films
import exercise.dicoding.maichel.dicodingmade.model.ResultFilm
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmService{
    @GET("movie/now_playing?" + BuildConfig.API_KEY + "&language=en-US")
    fun getFilm(): Call<ResultFilm>
}

interface UpcomingFilmService{
    @GET("tv/airing_today?" + BuildConfig.API_KEY + "&language=en-US&region=id")
    fun getUpcomingFilm():Call<ResultFilm>
}

interface CastingService {
    val id: String
    @GET("movie/{id}/credits?" + BuildConfig.API_KEY)
    fun getFilmsCasting(@Path("id")id:String): Call<Cast>
}

interface CastingTVService{
    val id: String
    @GET("tv/{id}/credits?" + BuildConfig.API_KEY)
    fun getTvCasting(@Path("id")id:String): Call<Cast>
}
