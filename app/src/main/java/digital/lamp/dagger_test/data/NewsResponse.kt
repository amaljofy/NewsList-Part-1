package digital.lamp.dagger_test.data
import com.google.gson.annotations.SerializedName
/**
 * Created by Amal Jofy Dept. on 11,March,2020
 */
data class NewsResponse(
        @field:SerializedName("title")
        val title: String,
        @field:SerializedName("description")
        val desc: String,
        @field:SerializedName("language")
        val language: String,
        @field:SerializedName("item")
        val newsList: List<NewsItem>
)