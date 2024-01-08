package uz.ibrokhimov.mynewsapi.core.presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.ibrokhimov.mynewsapi.core.model.NewsResponse
import uz.ibrokhimov.mynewsapi.core.network.ApiClient
import uz.ibrokhimov.mynewsapi.core.util.API_KEY
import java.io.IOException

class HomePresenter(private val view: HomeMVP.View) : HomeMVP.Presenter {

    private val api = ApiClient.createService()

    override fun getNewsData() {

        api.getEverythingNews("kotlin", API_KEY).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {

                if (response.isSuccessful) {
                    view.setNewsData(response.body()!!)
                } else {
                    view.setError(response.message())
                }

            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

                if (t is IOException){

                    view.setNetworkError("Network error")
                }

            }


        })

    }


}