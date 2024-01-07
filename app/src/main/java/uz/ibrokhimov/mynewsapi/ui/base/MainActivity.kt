package uz.ibrokhimov.mynewsapi.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.ibrokhimov.mynewsapi.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}