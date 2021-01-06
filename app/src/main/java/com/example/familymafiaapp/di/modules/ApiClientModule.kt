package com.example.familymafiaapp.di.modules

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import com.example.familymafiaapp.BuildConfig
import com.example.familymafiaapp.network.ApiClient
import com.readystatesoftware.chuck.ChuckInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@Module
class ApiClientModule {

    companion object {

        private const val BASE_URL = "https://sheets.googleapis.com/v4/spreadsheets/"
    }

    @Provides
    @Singleton
    internal fun provideApiClient(retrofit: Retrofit): ApiClient = ApiClient(retrofit)

    @Provides
    @Singleton
    internal fun provideRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        application: Application,
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .protocols(listOf(Protocol.HTTP_1_1))
            .addInterceptor(ChuckInterceptor(application))

        if (BuildConfig.DEBUG_NETWORK) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        return builder.build()
    }
}