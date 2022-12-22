package com.redmechax00.astonintensive2.ui.chapter22

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.databinding.ActivityHomework22Binding

class HomeworkActivity22 : AppCompatActivity() {

    companion object {
        const val EXTRA_TEXT = "text"
    }

    private lateinit var binding: ActivityHomework22Binding

    private lateinit var btnCount: Button
    private lateinit var text: TextView
    private lateinit var edText: EditText

    private var mCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework22Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        btnCount = binding.homework22Count
        text = binding.homework22Text
        edText = binding.homework22EdText
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        restoreText(savedInstanceState.getString(EXTRA_TEXT))
    }

    private fun restoreText(savedText: String?) {
        mCount = (savedText ?: "0").toInt()
        text.text = savedText
    }

    override fun onResume() {
        super.onResume()
        setOnClickListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_TEXT, text.text.toString())
    }


    override fun onPause() {
        super.onPause()
        removeOnClickListeners()
    }

    private fun setOnClickListeners() {
        btnCount.setOnClickListener { onCount() }
    }

    private fun removeOnClickListeners() {
        btnCount.setOnClickListener(null)
    }

    private fun onCount() {
        mCount++
        text.text = mCount.toString()
    }
}