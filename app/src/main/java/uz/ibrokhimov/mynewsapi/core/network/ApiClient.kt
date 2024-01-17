package uz.ibrokhimov.mynewsapi.core.network

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    fun createService() :NewsService = getRetrofit().create(NewsService::class.java)

}