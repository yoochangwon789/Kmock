package com.yoochangwonspro.kmock.di

import com.yoochangwonspro.kmock.data.model.network.buildOkHttpClient
import com.yoochangwonspro.kmock.data.model.network.providerGsonConverterFactory
import com.yoochangwonspro.kmock.data.model.network.providerLecture
import com.yoochangwonspro.kmock.data.model.network.providerLectureRetrofit
import org.koin.dsl.module

val appModule = module {

    // ProviderAPI
    single { providerGsonConverterFactory() }
    single { providerLecture(get()) }
    single { providerLectureRetrofit(get(), get()) }
    single { buildOkHttpClient() }
}