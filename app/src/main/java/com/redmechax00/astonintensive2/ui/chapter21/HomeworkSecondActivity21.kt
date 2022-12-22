package com.redmechax00.astonintensive2.ui.chapter21

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.databinding.ActivityHomeworkSecond21Binding


class HomeworkSecondActivity21 : AppCompatActivity() {

    private lateinit var binding: ActivityHomeworkSecond21Binding
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeworkSecond21Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        printExtraMessage()
    }

    private fun initView() {
        textView = binding.homework21ShowMessage
    }

    private fun printExtraMessage() {
        val intent = intent
        val message = intent.getStringExtra(HomeworkMainActivity21.EXTRA_MESSAGE)
        textView.text = "${App.Strings.get(R.string.chapter_21_hello_message)}$message"
    }
}