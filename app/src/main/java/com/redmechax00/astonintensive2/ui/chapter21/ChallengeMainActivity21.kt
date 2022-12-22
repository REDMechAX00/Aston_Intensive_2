package com.redmechax00.astonintensive2.ui.chapter21

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.databinding.ActivityChallengeMain21Binding

class ChallengeMainActivity21 : AppCompatActivity() {

    companion object {
        const val EXTRA_MESSAGE = "com.redmechax00.astonintensive2.ui.chapter21.extra.MESSAGE"
    }

    private lateinit var binding: ActivityChallengeMain21Binding
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeMain21Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        btnOne = binding.challenge21ButtonMainOne
        btnTwo = binding.challenge21ButtonMainTwo
        btnThree = binding.challenge21ButtonMainThree
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
        btnOne.setOnClickListener { launchSecondActivity(App.Strings.get(R.string.chapter_21_message_part_one)) }
        btnTwo.setOnClickListener { launchSecondActivity(App.Strings.get(R.string.chapter_21_message_part_two)) }
        btnThree.setOnClickListener { launchSecondActivity(App.Strings.get(R.string.chapter_21_message_part_three)) }
    }

    private fun removeOnClickListeners() {
        btnOne.setOnClickListener(null)
        btnTwo.setOnClickListener(null)
        btnThree.setOnClickListener(null)
    }

    private fun launchSecondActivity(message: String) {
        val intent = Intent(this, ChallengeSecondActivity21::class.java)
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivity(intent)
    }

}