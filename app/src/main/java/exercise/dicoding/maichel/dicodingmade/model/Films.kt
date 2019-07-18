package exercise.dicoding.maichel.dicodingmade.model

import com.google.gson.annotations.SerializedName

data class Films (
    @SerializedName("original_title")
    var original_title:String? = null,

    @SerializedName("adult")
    var adult:String? = null,

    @SerializedName("overview")
    var overview:String? = null,

    @SerializedName("poster_path")
    var poster_path:String? = null
)