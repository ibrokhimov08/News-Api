package uz.ibrokhimov.mynewsapi.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import uz.ibrokhimov.mynewsapi.R
import uz.ibrokhimov.mynewsapi.databinding.ScreenDetailBinding

class ScreenDetail : Fragment(R.layout.screen_detail) {

    private val binding by lazy { ScreenDetailBinding.inflate(layoutInflater) }
    private val args:ScreenDetailArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadView()
        loadAction()

    }

    private fun loadAction() {

      binding.backBtn.setOnClickListener {

          findNavController().popBackStack()

      }

    }

    private fun loadView() {
        binding.image.load(args.articles.urlToImage)
        binding.publishedAt.text = args.articles.publishedAt
        binding.text.text = args.articles.description
        binding.title.text = args.articles.title
        binding.about.text = args.articles.content
    }


}