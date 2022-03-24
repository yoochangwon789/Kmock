package com.yoochangwonspro.kmock.data.repository

import com.yoochangwonspro.kmock.data.model.Lecture
import kotlinx.coroutines.CoroutineDispatcher

class DefaultLectureRepository(
    private val lectureApi: LectureRepository,
    private val ioDispatcher: CoroutineDispatcher
) : LectureRepository {

    override suspend fun getLectureList(): List<Lecture> {
        TODO("Not yet implemented")
    }
}