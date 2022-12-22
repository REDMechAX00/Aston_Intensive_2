package com.redmechax00.astonintensive2.ui.chapter21

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.databinding.ActivityHomeworkMain21Binding

class HomeworkMainActivity21 : AppCompatActivity() {

    companion object {
        const val EXTRA_MESSAGE = "com.redmechax00.astonintensive2.ui.chapter21.extra.MESSAGE"
    }

    private lateinit var binding: ActivityHomeworkMain21Binding

    private lateinit var mShowCount: TextView
    private lateinit var mBtnSay: Button
    private lateinit var mBtnCount: Button

    private var mCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeworkMain21Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        mShowCount = binding.homework21ShowCount
        mBtnSay = binding.homework21ButtonSay
        mBtnCount = binding.homework21ButtonCount
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
        mBtnSay.setOnClickListener { onSay() }
        mBtnCount.setOnClickListener { countUp() }
    }

    private fun removeOnClickListeners() {
        mBtnSay.setOnClickListener(null)
        mBtnCount.setOnClickListener(null)
    }

    private fun onSay() {
        val intent = Intent(this, HomeworkSecondActivity21::class.java)
        intent.putExtra(EXTRA_MESSAGE, "$mCount")
        startActivity(intent)
    }

    private fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
    }
}