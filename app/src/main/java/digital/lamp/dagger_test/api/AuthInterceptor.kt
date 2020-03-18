package digital.lamp.dagger_test.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Created by Amal Jofy Dept. on 03,March,2020
 */
class AuthInterceptor(private val accessToken: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader(
                "Authorization", "key $accessToken").build()
        return chain.proceed(request)
    }
}
