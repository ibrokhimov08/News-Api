package uz.ibrokhimov.mynewsapi.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.ibrokhimov.mynewsapi.R
import uz.ibrokhimov.mynewsapi.core.adapter.NewsAdapter
import uz.ibrokhimov.mynewsapi.core.model.NewsResponse
import uz.ibrokhimov.mynewsapi.core.presenter.HomeMVP
import uz.ibrokhimov.mynewsapi.core.presenter.HomePresenter
import uz.ibrokhimov.mynewsapi.databinding.ScreenHomeBinding

class HomeScreen : Fragment(), HomeMVP.View {

    private val binding by lazy { ScreenHomeBinding.inflate(layoutInflater) }
    private var presenter: HomeMVP.Presenter? = null
    private val adapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadAdapter()
        loadPresenter()
        loadAction()

    }


    private fun loadAction() {

        adapter.itemNewsClick = {
            findNavController().navigate(HomeScreenDirections.homeToDetail(it))
        }

    }

    private fun loadPresenter() {
        presenter = HomePresenter(this)
        presenter?.getNewsData()
    }

    private fun loadAdapter() {

        binding.recyclerView.adapter = adapter

    }

    override fun setNewsData(data: NewsResponse) {

        data.articles?.let {
            adapter.setData(it)
        }

    }

    override fun setError(message: String) {



    }

    override fun setNetworkError(s: String) {

    }


}