package com.example.namo.Data

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


object ApiClient {
    private const val BASE_URL = "https://umcserverst.shop"
    private var prefs: SharedPreferences? = null

    fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            //.client(provideOkHttpClient(AppInterceptor()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

//    private fun provideOkHttpClient(
//        interceptor: AppInterceptor
//    ): OkHttpClient = OkHttpClient.Builder()
//        .run {
//            addInterceptor(interceptor)
//            build()
//        }
//
//    class AppInterceptor : Interceptor {
//        @Throws(IOException::class)
//        override fun intercept(chain: Interceptor.Chain) = with(chain) {
//
//            val accessToken=prefs?.getString("accessToken","")
//
//            val newRequest = request().newBuilder()
//                .addHeader("ACCESS-TOKEN", "$accessToken")
//                .addHeader("AUTH-SITE", "kakao")
//                .build()
//
//            proceed(newRequest)
//        }
//    }
}