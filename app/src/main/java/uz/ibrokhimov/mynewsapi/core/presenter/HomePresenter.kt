package uz.ibrokhimov.mynewsapi.core.presenter


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import uz.ibrokhimov.mynewsapi.core.model.use.everything.EverythingNewsResponse
import uz.ibrokhimov.mynewsapi.core.model.use.top_headline.TopHeadlineResponse
import uz.ibrokhimov.mynewsapi.core.network.ApiClient
import uz.ibrokhimov.mynewsapi.core.util.API_KEY

class HomePresenter(private val view: HomeMVP.View) : HomeMVP.Presenter {

    private val api = ApiClient.createService()

    override fun getEverythingData(dataType :String) {

        api.getEverythingNews(dataType, API_KEY, 15)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<EverythingNewsResponse>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                }

                override fun onSuccess(t: Response<EverythingNewsResponse>) {
                    if (t.isSuccessful) {
                        view.setEverythingData(t.body()!!)
                    }
                }
            })
    }



    override fun getTopHeadline() {

        api.getTopHeadlineNews("kotlin" , API_KEY, 10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<TopHeadlineResponse>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onSuccess(t: Response<TopHeadlineResponse>) {
                    if (t.isSuccessful) {
                        view.setHeadlineData(t.body()!!)
                    }else{
                        view.setError(t.message().toString())
                    }
                }

                override fun onError(e: Throwable) {
                }

            })

    }


}