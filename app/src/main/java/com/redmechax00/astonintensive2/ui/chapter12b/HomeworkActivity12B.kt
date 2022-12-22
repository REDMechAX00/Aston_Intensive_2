package com.redmechax00.astonintensive2.ui.chapter12b

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.databinding.ActivityHomework12BBinding
import com.redmechax00.astonintensive2.utils.showToast

class HomeworkActivity12B : AppCompatActivity() {

    private lateinit var binding: ActivityHomework12BBinding

    private lateinit var mShowCount: TextView
    private lateinit var mBtnToast: Button
    private lateinit var mBtnCount: Button
    private lateinit var mBtnZero: Button

    private var mCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework12BBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mShowCount = binding.homework12BShowCount
        mBtnToast = binding.homework12BButtonToast
        mBtnCount = binding.homework12BButtonCount
        mBtnZero = binding.homework12BButtonZero
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
        mBtnZero.setOnClickListener { onZero() }
    }

    private fun removeOnClickListeners() {
        mBtnToast.setOnClickListener(null)
        mBtnCount.setOnClickListener(null)
        mBtnZero.setOnClickListener(null)
    }

    private fun onToast() {
        showToast("${App.Strings.get(R.string.chapter_12_toast_message)} $mCount")
    }

    private fun countUp() {
        mCount++
        mShowCount.text = mCount.toString()
        mBtnZero.setTintColor(R.color.purple_600)

        if (mCount % 2 == 0) mBtnCount.setTintColor(R.color.purple_700)
        else mBtnCount.setTintColor(R.color.teal_700)
    }

    private fun onZero() {
        mCount = 0
        mShowCount.text = mCount.toString()
        mBtnZero.setTintColor(R.color.gray)
        mBtnCount.setTintColor(R.color.purple_700)
    }

    private fun Button.setTintColor(colorRes: Int) {
        background.setTint(App.Colors.get(colorRes))
    }
}