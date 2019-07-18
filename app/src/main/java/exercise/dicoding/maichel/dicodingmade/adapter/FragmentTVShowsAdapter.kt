package exercise.dicoding.maichel.dicodingmade.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import exercise.dicoding.maichel.dicodingmade.model.Films

class FragmentTVShowsAdapter(private val tv_shows: List<Films>): RecyclerView.Adapter<FragmentTVShowsAdapter.tvHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tvHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: tvHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class tvHolder(itemView:View):RecyclerView.ViewHolder(itemView){

    }
}