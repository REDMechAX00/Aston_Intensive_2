package com.redmechax00.astonintensive2.ui.main

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.databinding.ActivityMainBinding
import com.redmechax00.astonintensive2.utils.checkChapterIsViewed
import com.redmechax00.astonintensive2.utils.clearViewedHistory
import com.redmechax00.astonintensive2.utils.setBackgroundColorFilter
import com.redmechax00.astonintensive2.utils.startChapterMenu


class MainActivity : AppCompatActivity(), OnClickListener {

    companion object {
        const val KEY_CLEAR_VIEWED_HISTORY = "clear_viewed_history"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var listOfButtons: List<Button>

    private var clearViewedHistory = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        listOfButtons = listOf(
            binding.mainBtnLesson11,
            binding.mainBtnLesson12A,
            binding.mainBtnLesson12B,
            binding.mainBtnLesson13,
            binding.mainBtnLesson14,
            binding.mainBtnLesson21,
            binding.mainBtnLesson22,
            binding.mainBtnLesson23
        )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        clearViewedHistory = savedInstanceState.getBoolean(KEY_CLEAR_VIEWED_HISTORY, true)
    }

    override fun onResume() {
        super.onResume()
        setOnClickListeners()
        prepareButtons()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_CLEAR_VIEWED_HISTORY, false)
    }

    override fun onPause() {
        super.onPause()
        removeOnClickListeners()
    }

    override fun onClick(v: View?) {
        startChapterMenu(ChapterActivity(), (v as Button).text.toString())
    }

    private fun prepareButtons() {
        if (clearViewedHistory) clearViewedHistory = clearViewedHistory()

        listOfButtons.forEach {
            if (checkChapterIsViewed(it.text.toString())) {
                it.setBackgroundColorFilter(App.Colors.get(R.color.color_primary_checked))
            } else {
                it.setBackgroundColorFilter(App.Colors.get(R.color.color_primary))
            }
        }
    }

    private fun setOnClickListeners() {
        listOfButtons.forEach { it.setOnClickListener(this) }
    }

    private fun removeOnClickListeners() {
        listOfButtons.forEach { it.setOnClickListener(null) }
    }
}