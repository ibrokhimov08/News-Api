package uz.ibrokhimov.mynewsapi.core.model.use.everything


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    val id: String?, // t3n
    @SerializedName("name")
    val name: String? // heise online
)