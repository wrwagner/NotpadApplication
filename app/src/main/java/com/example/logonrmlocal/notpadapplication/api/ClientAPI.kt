package com.example.logonrmlocal.notpadapplication.api


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ClientApi<T> {

    fun getClient(c: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .client(getOkhttpClientAuth().build())
                .baseUrl("https://blocodenotaswagner.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(c)
    }

}

fun getOkhttpClientAuth(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
            //.addInterceptor(AuthInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
}

/*class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val requestBuilder = chain!!.request().newBuilder()
        requestBuilder.addHeader("Authorization", "Basic cG9rZWFwaTpwb2tlbW9u")
        val request = requestBuilder.build()
        val response = chain.proceed(request)
        if (response.code() == 401) {
            Log.e("MEUAPP", "Error API KEY")
        }
        return response
    }
}*/

fun getNotaAPI(): NotaAPI {
    return ClientApi<NotaAPI>().getClient(NotaAPI::class.java)
}