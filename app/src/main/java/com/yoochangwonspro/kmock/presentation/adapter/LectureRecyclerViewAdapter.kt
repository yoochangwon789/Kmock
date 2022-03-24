package com.yoochangwonspro.kmock.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoochangwonspro.kmock.data.model.Lecture
import com.yoochangwonspro.kmock.databinding.LectureItemBinding

class LectureRecyclerViewAdapter(

) : RecyclerView.Adapter<LectureRecyclerViewAdapter.ViewHolder>() {

    private var lectureList: List<Lecture> = listOf()

    class ViewHolder(private val binding: LectureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(lecture: Lecture) = with(binding) {
            itemLectureTitleTextView.text = lecture.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LectureItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lectureList[position])
    }

    override fun getItemCount(): Int = lectureList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setLectureList(lectureList: List<Lecture>) {
        this.lectureList = lectureList
        notifyDataSetChanged()
    }
}