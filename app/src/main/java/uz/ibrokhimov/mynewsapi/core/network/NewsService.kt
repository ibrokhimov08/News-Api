package uz.ibrokhimov.mynewsapi.core.network

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.ibrokhimov.mynewsapi.core.model.use.everything.EverythingNewsResponse
import uz.ibrokhimov.mynewsapi.core.model.use.top_headline.TopHeadlineResponse

interface NewsService {

    @GET("/v2/everything")
    fun getEverythingNews(
        @Query("q") q: String,
        @Query("apiKey") key: String,
        @Query("pageSize") size: Int
    ): Single<Response<EverythingNewsResponse>>


    @GET("/v2/top-headlines")
    fun getTopHeadlineNews(
        @Query("q") q: String,
        @Query("apiKey") key: String,
        @Query("pageSize") size: Int
    ): Single<Response<TopHeadlineResponse>>


}