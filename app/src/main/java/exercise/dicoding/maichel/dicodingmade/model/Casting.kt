package exercise.dicoding.maichel.dicodingmade.model

import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("cast")
    var cast:ArrayList<Casting>
)

data class Casting(
    @SerializedName("name")
    var name:String? = null,

    @SerializedName("character")
    var character:String? = null
)