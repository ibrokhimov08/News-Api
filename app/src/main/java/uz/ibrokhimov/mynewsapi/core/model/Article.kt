package uz.ibrokhimov.mynewsapi.core.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Article(
    @SerializedName("author")
    val author: String?, // Rainald Menge-Sonnentag
    @SerializedName("content")
    val content: String?, // InhaltsverzeichnisGut einen Monat nach der ersten stabilen Variante von Kotlin Multiplatform geht JetBrains nun die Zielplattform WebAssembly an. Kotlin/Wasm hat nun Alpha-Status, nachdem die Anbin… [+2378 chars]
    @SerializedName("description")
    val description: String?, // Die Programmiersprache Kotlin startet die Alphaphase für die Anbindung von WebAssembly als Zielplattform bei der Cross-Plattform-Entwicklung.
    @SerializedName("publishedAt")
    val publishedAt: String?, // 2023-12-14T07:22:00Z
    @SerializedName("source")
    val source: Source?,
    @SerializedName("title")
    val title: String?, // Kotlin lernt WebAssembly – jetzt aber wirklich
    @SerializedName("url")
    val url: String?, // https://www.heise.de/news/Kotlin-lernt-WebAssembly-jetzt-aber-wirklich-9573392.html
    @SerializedName("urlToImage")
    val urlToImage: String? // https://heise.cloudimg.io/bound/1200x1200/q85.png-lossy-85.webp-lossy-85.foil1/_www-heise-de_/imgs/18/4/5/1/3/3/5/4/shutterstock_1128653108-aa4149ea32f19b5a.jpg
):Serializable