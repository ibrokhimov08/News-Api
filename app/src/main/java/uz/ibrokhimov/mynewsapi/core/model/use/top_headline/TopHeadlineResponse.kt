package uz.ibrokhimov.mynewsapi.core.model.use.top_headline


import com.google.gson.annotations.SerializedName
import uz.ibrokhimov.mynewsapi.core.model.base.BaseModel

data class TopHeadlineResponse(
    @SerializedName("articles")
    val articles: List<TopHeadlineArticle>?,
    @SerializedName("status")
    val status: String?, // ok
    @SerializedName("totalResults")
    val totalResults: Int? // 196
):BaseModel(){
    override fun getType(): Int {

        return TOP_HEAD_LINE

    }


}