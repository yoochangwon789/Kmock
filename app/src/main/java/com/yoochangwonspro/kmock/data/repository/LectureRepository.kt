package com.yoochangwonspro.kmock.data.repository

import com.yoochangwonspro.kmock.data.model.Lecture

interface LectureRepository {

    suspend fun getLectureList(): List<Lecture>
}