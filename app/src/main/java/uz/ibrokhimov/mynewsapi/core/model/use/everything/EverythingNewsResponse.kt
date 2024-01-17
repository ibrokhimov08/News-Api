package uz.ibrokhimov.mynewsapi.core.model.use.everything


import com.google.gson.annotations.SerializedName
import uz.ibrokhimov.mynewsapi.core.model.base.BaseModel

data class EverythingNewsResponse(
    @SerializedName("articles")
    val articles: List<EverythingArticle?>?,
    @SerializedName("status")
    val status: String?, // ok
    @SerializedName("totalResults")
    val totalResults: Int? // 196
):BaseModel(){
    override fun getType(): Int {

        return EVERY_THING

    }


}