package com.redmechax00.astonintensive2.ui.chapter21

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.databinding.ActivityChallengeSecond21Binding


class ChallengeSecondActivity21 : AppCompatActivity() {

    private lateinit var binding: ActivityChallengeSecond21Binding
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeSecond21Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        printExtraMessage()
    }

    private fun initView() {
        textView = binding.challenge21TextMessage
    }

    private fun printExtraMessage() {
        val intent = intent
        val message = intent.getStringExtra(ChallengeMainActivity21.EXTRA_MESSAGE)
        textView.text = message
    }
}