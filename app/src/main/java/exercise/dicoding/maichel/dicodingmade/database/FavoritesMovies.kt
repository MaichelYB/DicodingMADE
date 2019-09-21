package exercise.dicoding.maichel.dicodingmade.database

data class FavoritesMovies(
    val title:String?,
    val imgSrc:String?,
    val date:String?,
    val caster:String?,
    val summ:String?,
    val status:String?
){
    companion object{
        const val TABLE_FAVORITES_FILM:String = "TABLE_FAVORITES_FILM"
        const val TITLE:String = "TITLE"
        const val IMGSRC:String = "IMGSRC"
        const val DATE:String = "DATE"
        const val CASTER:String = "CASTER"
        const val SUMM:String = "SUMMARY"
        const val STATUS:String = "STATUS"
    }
}