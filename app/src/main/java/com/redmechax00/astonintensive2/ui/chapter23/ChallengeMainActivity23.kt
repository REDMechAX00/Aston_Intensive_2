package com.redmechax00.astonintensive2.ui.chapter23

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.databinding.ActivityChallengeMain23Binding
import com.redmechax00.astonintensive2.utils.showToast

class ChallengeMainActivity23 : AppCompatActivity() {
    companion object {
        const val EXTRA_ITEM_ARRAY = "item_list"
    }

    private lateinit var binding: ActivityChallengeMain23Binding
    private lateinit var listOfText: List<TextView>
    private lateinit var edTextShopName: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSearch: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeMain23Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        edTextShopName = binding.challenge23EdittextShop
        btnAdd = binding.challenge23BtnAdd
        btnSearch = binding.challenge23BtnSearch
        listOfText = listOf(
            binding.challenge23ItemOne,
            binding.challenge23ItemTwo,
            binding.challenge23ItemThree,
            binding.challenge23ItemFour,
            binding.challenge23ItemFive,
            binding.challenge23ItemSix,
            binding.challenge23ItemSeven,
            binding.challenge23ItemEight,
            binding.challenge23ItemNine,
            binding.challenge23ItemTen
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
        btnSearch.setOnClickListener { searchShop() }
    }

    private fun removeOnClickListeners() {
        btnAdd.setOnClickListener(null)
    }

    private fun onStartItemChooser() {
        val intent = Intent(this, ChallengeSecondActivity23::class.java)
        resultLauncher.launch(intent)
    }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val itemText = data?.getStringExtra(ChallengeSecondActivity23.EXTRA_REPLY)
                if (!itemText.isNullOrEmpty()) {
                    addItemToList(itemText)
                }
            }
        }

    private fun searchShop() {
        val shop = edTextShopName.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$shop")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d(
                App.Strings.get(R.string.chapter_23_log_tag),
                App.Strings.get(R.string.chapter_23_log_msg1)
            )
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