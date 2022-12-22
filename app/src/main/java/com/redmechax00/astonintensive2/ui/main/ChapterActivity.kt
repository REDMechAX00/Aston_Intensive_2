package com.redmechax00.astonintensive2.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.data.SharedPreference
import com.redmechax00.astonintensive2.databinding.ActivityChapterBinding
import com.redmechax00.astonintensive2.utils.*


class ChapterActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityChapterBinding
    private lateinit var chapterTitle: String

    private lateinit var textTitle: TextView
    private lateinit var btnHomework: Button
    private lateinit var btnChallenge: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChapterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chapterTitle = intent.getStringExtra(TAG_EXTRA_CHAPTER) ?: ""

        initView()
    }

    private fun initView() {
        textTitle = binding.chapterTextTitle
        btnHomework = binding.chapterBtnHomework
        btnChallenge = binding.chapterBtnChallenge
    }

    override fun onResume() {
        super.onResume()
        setOnClickListeners()
        prepareText()
        prepareButtons()
    }

    override fun onPause() {
        super.onPause()
        removeOnClickListeners()
    }

    override fun onClick(v: View?) {
        when (v) {
            btnHomework -> {
                startTaskActivity(TasksFactory.getHomework(chapterTitle)) {
                    setTaskIsViewed(chapterTitle, TAG_HOMEWORK)
                }
            }
            btnChallenge -> {
                startTaskActivity(TasksFactory.getChallenge(chapterTitle)) {
                    setTaskIsViewed(chapterTitle, TAG_CHALLENGE)
                }
            }
        }
    }

    private fun prepareText() {
        textTitle.text = chapterTitle
    }

    private fun prepareButtons() {
        if (TasksFactory.getHomework(chapterTitle) == null) btnHomework.visibility = View.GONE
        else btnHomework.visibility = View.VISIBLE
        if (TasksFactory.getChallenge(chapterTitle) == null) btnChallenge.visibility = View.GONE
        else btnChallenge.visibility = View.VISIBLE

        if (checkTaskIsViewed(chapterTitle, TAG_HOMEWORK)) {
            btnHomework.setBackgroundColorFilter(App.Colors.get(R.color.color_primary_checked))
        } else {
            btnHomework.setBackgroundColorFilter(App.Colors.get(R.color.color_primary))
        }
        if (checkTaskIsViewed(chapterTitle, TAG_CHALLENGE)) {
            btnChallenge.setBackgroundColorFilter(App.Colors.get(R.color.color_primary_checked))
        } else {
            btnChallenge.setBackgroundColorFilter(App.Colors.get(R.color.color_primary))
        }
    }

    private fun setTaskIsViewed(chapterTitle: String, taskType: String) {
        val editor: SharedPreferences.Editor = SharedPreference(this).sharedPref.edit()
        editor.putBoolean(chapterTitle + taskType, true)
        editor.apply()
    }

    private fun setOnClickListeners() {
        btnHomework.setOnClickListener(this)
        btnChallenge.setOnClickListener(this)
    }

    private fun removeOnClickListeners() {
        btnHomework.setOnClickListener(null)
        btnChallenge.setOnClickListener(null)
    }
}