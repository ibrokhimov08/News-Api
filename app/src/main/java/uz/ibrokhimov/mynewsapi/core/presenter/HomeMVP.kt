package uz.ibrokhimov.mynewsapi.core.presenter

import uz.ibrokhimov.mynewsapi.core.model.NewsResponse

interface HomeMVP {

    interface View{
        fun setNewsData(data:NewsResponse)
        fun setError(message: String)
        fun setNetworkError(s: String)
    }
    interface Presenter{
        fun getNewsData()
    }

}