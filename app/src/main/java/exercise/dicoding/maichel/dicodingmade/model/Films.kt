package exercise.dicoding.maichel.dicodingmade.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ResultFilm(
    @SerializedName("results")
    val results:ArrayList<Films>
)

@Parcelize
data class Films (
    @SerializedName("id")
    var id:String? = null,

    @SerializedName("name")
    var name:String? = null,

    @SerializedName("original_title")
    var original_title:String? = null,

    @SerializedName("adult")
    var adult:String? = null,

    @SerializedName("overview")
    var overview:String? = null,

    @SerializedName("poster_path")
    var poster_path:String? = null,

    @SerializedName("release_date")
    var release_date:String? = null
):Parcelable