package com.yoochangwonspro.kmock.data.repository

import com.yoochangwonspro.kmock.data.model.Lecture
import com.yoochangwonspro.kmock.data.network.LectureService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DefaultLectureRepository(
    private val lectureApi: LectureService,
    private val ioDispatcher: CoroutineDispatcher
) : LectureRepository {

    override suspend fun getLectureList(): List<Lecture> = withContext(ioDispatcher) {
        val response = lectureApi.getLectures()

        return@withContext if (response.isSuccessful) {
            response.body()?.results ?: listOf()
        } else {
            listOf()
        }
    }
}