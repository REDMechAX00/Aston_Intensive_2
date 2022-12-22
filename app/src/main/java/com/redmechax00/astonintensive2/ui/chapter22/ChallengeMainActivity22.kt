package com.redmechax00.astonintensive2.ui.chapter22

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.databinding.ActivityChallengeMain22Binding
import com.redmechax00.astonintensive2.utils.showToast

class ChallengeMainActivity22 : AppCompatActivity() {

    companion object {
        const val EXTRA_ITEM_ARRAY = "item_list"
    }

    private lateinit var binding: ActivityChallengeMain22Binding
    private lateinit var listOfText: List<TextView>
    private lateinit var btnAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeMain22Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        btnAdd = binding.challenge22BtnAdd
        listOfText = listOf(
            binding.challenge22ItemOne,
            binding.challenge22ItemTwo,
            binding.challenge22ItemThree,
            binding.challenge22ItemFour,
            binding.challenge22ItemFive,
            binding.challenge22ItemSix,
            binding.challenge22ItemSeven,
            binding.challenge22ItemEight,
            binding.challenge22ItemNine,
            binding.challenge22ItemTen
        )
        listOfText.forEach { it.visibility = View.GONE }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        restoreListOfText(savedInstanceState.getStringArrayList(EXTRA_ITEM_ARRAY))
    }

    override fun onResume() {
        super.onResume()
        setOnClickListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList(EXTRA_ITEM_ARRAY, arrayListOfItems())
    }


    override fun onPause() {
        super.onPause()
        removeOnClickListeners()
    }

    private fun setOnClickListeners() {
        btnAdd.setOnClickListener { onStartItemChooser() }
    }

    private fun removeOnClickListeners() {
        btnAdd.setOnClickListener(null)
    }

    private fun onStartItemChooser() {
        val intent = Intent(this, ChallengeSecondActivity22::class.java)
        resultLauncher.launch(intent)
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val itemText = data?.getStringExtra(ChallengeSecondActivity22.EXTRA_REPLY)
                if (!itemText.isNullOrEmpty()) {
                    addItemToList(itemText)
                }
            }
        }

    private fun arrayListOfItems(): ArrayList<String> {
        val list = arrayListOf<String>()
        listOfText.forEach {
            list.add(it.text.toString())
        }
        return list
    }

    private fun restoreListOfText(list: ArrayList<String>?) {
        list?.forEach { s -> addItemToList(s) }
    }

    private fun addItemToList(itemText: String): Boolean {
        for (item: TextView in listOfText) {
            if (item.text.isEmpty()) {
                item.text = itemText
                item.visibility = View.VISIBLE
                return true
            }
        }
        showToast(getString(R.string.chapter_22_limit_exception))
        return false
    }
}