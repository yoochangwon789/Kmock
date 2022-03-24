package com.yoochangwonspro.kmock.data.network

import com.yoochangwonspro.kmock.data.model.Lectures
import com.yoochangwonspro.kmock.utillity.Url
import retrofit2.Response
import retrofit2.http.GET

interface LectureService {

    @GET(Url.BASE_URL)
    suspend fun getLectures(): Response<Lectures>
}