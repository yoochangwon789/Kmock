package com.yoochangwonspro.kmock.data.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.yoochangwonspro.kmock.BuildConfig
import com.yoochangwonspro.kmock.utillity.Url
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun providerLecture(retrofit: Retrofit): LectureService =
    retrofit.create(LectureService::class.java)

fun providerLectureRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory,
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Url.BASE_URL)
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
}

fun providerGsonConverterFactory(): GsonConverterFactory {
    return GsonConverterFactory.create(
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    )
}

fun buildOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) interceptor.level = HttpLoggingInterceptor.Level.BODY
    else interceptor.level = HttpLoggingInterceptor.Level.NONE

    return OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}