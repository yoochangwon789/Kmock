package com.yoochangwonspro.kmock.domain

import com.yoochangwonspro.kmock.data.model.Lecture
import com.yoochangwonspro.kmock.data.repository.LectureRepository

class GetLectureListUseCase(
    private val lectureRepository: LectureRepository
) {
    suspend operator fun invoke(): List<Lecture> = lectureRepository.getLectureList()
}