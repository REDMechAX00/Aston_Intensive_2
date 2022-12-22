package com.redmechax00.astonintensive2.ui.chapter23

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.databinding.ActivityChallengeSecond23Binding

class ChallengeSecondActivity23 : AppCompatActivity(), OnClickListener {
    companion object {
        const val EXTRA_REPLY = "com.redmechax00.astonintensive2.ui.chapter23.extra.REPLY"
    }

    private lateinit var binding: ActivityChallengeSecond23Binding

    private lateinit var itemList: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeSecond23Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        itemList = listOf(
            binding.challenge23Btn1,
            binding.challenge23Btn2,
            binding.challenge23Btn3,
            binding.challenge23Btn4,
            binding.challenge23Btn5,
            binding.challenge23Btn6,
            binding.challenge23Btn7,
            binding.challenge23Btn8,
            binding.challenge23Btn9,
            binding.challenge23Btn10,
            binding.challenge23Btn11,
            binding.challenge23Btn12,
            binding.challenge23Btn13,
            binding.challenge23Btn14,
            binding.challenge23Btn15
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