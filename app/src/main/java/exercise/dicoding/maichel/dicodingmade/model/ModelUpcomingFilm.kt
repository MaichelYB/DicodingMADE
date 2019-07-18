package exercise.dicoding.maichel.dicodingmade.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelUpcomingFilm(var title: String,
                             var img_source: String,
                             var directors: String,
                             var actors: String,
                             var synopsis: String,
                             var status:String) : Parcelable