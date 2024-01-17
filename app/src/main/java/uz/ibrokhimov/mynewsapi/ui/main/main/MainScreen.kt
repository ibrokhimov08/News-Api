package uz.ibrokhimov.mynewsapi.ui.main.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.ibrokhimov.mynewsapi.R
import uz.ibrokhimov.mynewsapi.core.adapter.main.MainScreenAdapter
import uz.ibrokhimov.mynewsapi.databinding.ScreenMainBinding

class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()

    }

    private fun setAdapter() {

        val adapter = MainScreenAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

    }
}