package com.yoochangwonspro.kmock.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoochangwonspro.kmock.R
import com.yoochangwonspro.kmock.data.repository.DefaultLectureRepository
import com.yoochangwonspro.kmock.databinding.ActivityMainBinding
import com.yoochangwonspro.kmock.presentation.adapter.LectureRecyclerViewAdapter
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val lectureRecyclerViewAdapter = LectureRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lectureRecyclerView.adapter = lectureRecyclerViewAdapter
        binding.lectureRecyclerView.layoutManager = LinearLayoutManager(this)


    }
}