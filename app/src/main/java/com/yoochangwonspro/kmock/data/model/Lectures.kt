package com.yoochangwonspro.kmock.data.model

data class Lectures(
    val count: Int,
    val numPages: Int,
    val next: String,
    val results: List<Lecture>
)
