package uz.ibrokhimov.mynewsapi.core.presenter

import uz.ibrokhimov.mynewsapi.core.model.use.everything.EverythingNewsResponse
import uz.ibrokhimov.mynewsapi.core.model.use.top_headline.TopHeadlineResponse

interface HomeMVP {

    interface View{
        fun setEverythingData(data: EverythingNewsResponse)
        fun setHeadlineData(data: TopHeadlineResponse)
        fun setError(message: String)
        fun setNetworkError(s: String)
    }
    interface Presenter{
        fun getEverythingData(dataType:String)
        fun getTopHeadline()
    }

}