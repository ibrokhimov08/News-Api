package uz.ibrokhimov.mynewsapi.ui.main.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.ibrokhimov.mynewsapi.R
import uz.ibrokhimov.mynewsapi.core.adapter.MultiAdapter
import uz.ibrokhimov.mynewsapi.core.model.base.BaseModel
import uz.ibrokhimov.mynewsapi.core.model.use.everything.EverythingNewsResponse
import uz.ibrokhimov.mynewsapi.core.model.use.top_headline.TopHeadlineResponse
import uz.ibrokhimov.mynewsapi.core.presenter.HomeMVP
import uz.ibrokhimov.mynewsapi.core.presenter.HomePresenter
import uz.ibrokhimov.mynewsapi.databinding.ScreenHomeBinding

class HomePage : Fragment(R.layout.screen_home), HomeMVP.View {


    private val binding by viewBinding(ScreenHomeBinding::bind)
    private var presenter: HomeMVP.Presenter? = null
    private val multiData = ArrayList<BaseModel>()
    private val adapter by lazy { MultiAdapter() }
    private var one = false
    private var two = false
    private var dataOfType = "kotlin"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadAdapter()
        loadPresenter(dataOfType)
        loadAction()
        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }


    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.kotlin -> {
                loadPresenter("kotlin")
                dataOfType = "kotlin"
                loadAdapter()
            }

            R.id.c -> {
                loadPresenter("c++")
                dataOfType = "c++"
                loadAdapter()
            }

            R.id.python -> {
                loadPresenter("python")
                dataOfType = "python"
                loadAdapter()
            }

            R.id.java -> {
                loadPresenter("java")
                dataOfType = "java"
                loadAdapter()
            }

        }


        return true
    }


    private fun loadAction() {

        /*   adapter.itemNewsClick = {
               findNavController().navigate(HomeScreenDirections.homeToDetail(it))
           }*/

    }

    private fun loadPresenter(dataType: String) {
        presenter = HomePresenter(this)
        presenter?.getTopHeadline()
        presenter?.getEverythingData(dataType)
        multiData.clear()
    }

    private fun loadAdapter() {
        binding.multiRecyclerView.adapter = adapter
        binding.multiRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.multiRecyclerView.setHasFixedSize(true)
    }

    override fun setEverythingData(data: EverythingNewsResponse) {
        this.multiData.add(data)
        two = true
        setDataToAdapter()
    }

    override fun setHeadlineData(data: TopHeadlineResponse) {
        this.multiData.add(data)
        one = true
        setDataToAdapter()
    }

    private fun setDataToAdapter() {
        if (one && two) {
            adapter.setData(multiData)
        }
    }

    override fun setError(message: String) {
    }

    override fun setNetworkError(s: String) {

    }


}