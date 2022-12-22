package com.redmechax00.astonintensive2.ui.chapter12b

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.databinding.ActivityChallenge12BBinding
import com.redmechax00.astonintensive2.utils.showToast

class ChallengeActivity12B : AppCompatActivity() {

    private lateinit var binding: ActivityChallenge12BBinding

    private lateinit var mShowCount: TextView
    private lateinit var mBtnToast: Button
    private lateinit var mBtnCount: Button

    private var mCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallenge12BBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        mShowCount = binding.challenge12BShowCount
        mBtnToast = binding.challenge12BButtonToast
        mBtnCount = binding.challenge12BButtonCount
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
        mBtnToast.setOnClickListener { onToast() }
        mBtnCount.setOnClickListener { countUp() }
    }

    private fun removeOnClickListeners() {
        mBtnToast.setOnClickListener(null)
        mBtnCount.setOnClickListener(null)
    }

    private fun onToast() {
        showToast(App.Strings.get(R.string.chapter_12_toast_message))
    }

    private fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
    }
}