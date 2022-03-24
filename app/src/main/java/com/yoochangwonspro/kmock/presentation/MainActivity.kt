package com.yoochangwonspro.kmock.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoochangwonspro.kmock.R
import com.yoochangwonspro.kmock.data.repository.DefaultLectureRepository
import com.yoochangwonspro.kmock.databinding.ActivityMainBinding
import com.yoochangwonspro.kmock.presentation.adapter.LectureRecyclerViewAdapter
import com.yoochangwonspro.kmock.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val lectureRecyclerViewAdapter = LectureRecyclerViewAdapter()

    private val viewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lectureRecyclerView.adapter = lectureRecyclerViewAdapter
        binding.lectureRecyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.lectureListLiveData.observe(this) { lectures ->
            lectureRecyclerViewAdapter.setLectureList(lectures)
        }
    }
}