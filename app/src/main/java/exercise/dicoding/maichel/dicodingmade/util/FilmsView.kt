package exercise.dicoding.maichel.dicodingmade.util

import exercise.dicoding.maichel.dicodingmade.model.Films

interface FilmsView {
    fun filmsShowLoading()
    fun filmsHideLoading()
    fun filmsShowDataList(data: List<Films>)
    fun showError(message: String)
}