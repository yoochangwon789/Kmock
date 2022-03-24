package com.yoochangwonspro.kmock.di

import com.yoochangwonspro.kmock.data.network.buildOkHttpClient
import com.yoochangwonspro.kmock.data.network.providerGsonConverterFactory
import com.yoochangwonspro.kmock.data.network.providerLecture
import com.yoochangwonspro.kmock.data.network.providerLectureRetrofit
import com.yoochangwonspro.kmock.data.repository.DefaultLectureRepository
import com.yoochangwonspro.kmock.data.repository.LectureRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {

    // Coroutine Dispatcher
    single { Dispatchers.IO }
    single { Dispatchers.Main }

    // ProviderAPI
    single { providerGsonConverterFactory() }
    single { providerLecture(get()) }
    single { providerLectureRetrofit(get(), get()) }
    single { buildOkHttpClient() }

    // Repository
    single<LectureRepository> { DefaultLectureRepository(get(),get()) }
}