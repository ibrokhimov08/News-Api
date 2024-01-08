package uz.ibrokhimov.mynewsapi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.ibrokhimov.mynewsapi.R
import uz.ibrokhimov.mynewsapi.databinding.ScreenHomeBinding

class HomeScreen :Fragment(R.layout.screen_home){

     private val binding by viewBinding(ScreenHomeBinding::bind)
    //private val binding by lazy { ScreenHomeBinding.inflate(layoutInflater) }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



}