package uz.ibrokhimov.mynewsapi.core.util

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

const val API_KEY = "c70f21abb2994315be4814b891a7c309"

fun Fragment.myToast(text:String){

    Toast.makeText(this.requireContext(), text, Toast.LENGTH_SHORT).show()

}

