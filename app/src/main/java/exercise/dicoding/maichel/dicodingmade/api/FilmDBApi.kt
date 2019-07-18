package exercise.dicoding.maichel.dicodingmade.api

import android.net.Uri
import exercise.dicoding.maichel.dicodingmade.BuildConfig

class FilmDBApi {

    fun getNowShowing():String{
        return BuildConfig.BASE_URL + "movie/now_playing?" + BuildConfig.API_KEY + "&language=en-US&region=id"
    }

    fun getUpcomingShowing():String{
        return BuildConfig.BASE_URL + "movie/upcoming?" + BuildConfig.API_KEY + "&language=en-US&region=id"
    }

    fun getPopularMovies():String{
        return BuildConfig.BASE_URL + "movie/pupolar?" + BuildConfig.API_KEY + "&language=en-US&page=1&region=id"
    }

    fun getTVShow():String{
        return BuildConfig.BASE_URL + "tv/airing_today?" + BuildConfig.API_KEY + "&language=en-US&page=1"
    }

    fun getPosterImage(id:String):String{
        return BuildConfig.IMAGE_URL + id
    }

    fun getCast(id:String):String{
        return BuildConfig.BASE_URL + "movie/${id}/credits?" + BuildConfig.API_KEY
    }
}