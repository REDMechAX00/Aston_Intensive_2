package com.redmechax00.astonintensive2.ui.chapter22

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.databinding.ActivityChallengeSecond22Binding


class ChallengeSecondActivity22 : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_REPLY = "com.redmechax00.astonintensive2.ui.chapter22.extra.REPLY"
    }

    private lateinit var binding: ActivityChallengeSecond22Binding

    private lateinit var itemList: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeSecond22Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        itemList = listOf(
            binding.challenge22Btn1,
            binding.challenge22Btn2,
            binding.challenge22Btn3,
            binding.challenge22Btn4,
            binding.challenge22Btn5,
            binding.challenge22Btn6,
            binding.challenge22Btn7,
            binding.challenge22Btn8,
            binding.challenge22Btn9,
            binding.challenge22Btn10,
            binding.challenge22Btn11,
            binding.challenge22Btn12,
            binding.challenge22Btn13,
            binding.challenge22Btn14,
            binding.challenge22Btn15
        )
    }

    override fun onResume() {
        super.onResume()
        setOnClickListeners()
    }

    override fun onPause() {
        super.onPause()
        removeOnClickListeners()
    }

    private fun setOnClickListeners() {
        itemList.forEach { it.setOnClickListener(this) }
    }

    private fun removeOnClickListeners() {
        itemList.forEach { it.setOnClickListener(null) }
    }

    override fun onClick(v: View?) {
        returnReply(v as Button)
    }

    private fun returnReply(v: Button) {
        val reply: String = v.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}