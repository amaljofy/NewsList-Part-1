package digital.lamp.dagger_test.api

import digital.lamp.dagger_test.data.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Amal Jofy Dept. on 03,March,2020
 */
interface AppService {
    companion object {
        const val ENDPOINT = "https://api.dailycaller.com/section/"
    }

    @GET("US?feed=fullsection&key=90ac1808fa3e0d0679464da550202a0a&json=yes")
    suspend fun   getNewsList(@Query("paged") page: Int? = null,
                          @Query("max_posts") limit: Int? = null) : NewsResponse

}