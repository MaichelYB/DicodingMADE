package exercise.dicoding.maichel.dicodingmade.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import exercise.dicoding.maichel.dicodingmade.fragments.FragmentMovies
import exercise.dicoding.maichel.dicodingmade.fragments.FragmentTvShows

class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private val pages = listOf<Fragment>(
        FragmentMovies(),
        FragmentTvShows()
    )
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Movies"
            else -> "Tv Shows"
        }
    }
}