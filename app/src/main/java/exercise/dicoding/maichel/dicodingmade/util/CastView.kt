package exercise.dicoding.maichel.dicodingmade.util

import exercise.dicoding.maichel.dicodingmade.model.Casting

interface CastView {
    fun castShowLoading()
    fun castHideLoading()
    fun castShowDataList(data: List<Casting>)
    fun castError(message: String)
}