package uz.ibrokhimov.mynewsapi.core.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import uz.ibrokhimov.mynewsapi.core.model.NewsResponse

interface NewsService {

    @GET("/v2/everything")
    fun getEverythingNews(
        @Query("q") q: String,
        @Query("apiKey") key: String
    ): Call<NewsResponse>



}