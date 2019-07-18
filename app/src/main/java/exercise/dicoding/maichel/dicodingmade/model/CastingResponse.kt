package exercise.dicoding.maichel.dicodingmade.model

import com.google.gson.annotations.SerializedName

data class CastingResponse (
    @SerializedName("cast")
    val cast: List<Casting>
)