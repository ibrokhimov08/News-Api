package uz.ibrokhimov.mynewsapi.core.adapter.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.ibrokhimov.mynewsapi.ui.main.home.HomePage
import uz.ibrokhimov.mynewsapi.ui.main.save.SavePage

class MainScreenAdapter(fm :FragmentManager, lc: Lifecycle) :FragmentStateAdapter(fm , lc ) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> HomePage()
            else -> SavePage()
        }
    }

}