package com.redmechax00.astonintensive2.ui.chapter23

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.databinding.ActivityHomework23Binding


class HomeworkActivity23 : AppCompatActivity() {

    private lateinit var binding: ActivityHomework23Binding

    private lateinit var mWebsiteEditText: EditText
    private lateinit var mLocationEditText: EditText
    private lateinit var mShareTextEditText: EditText
    private lateinit var mBtnUri: Button
    private lateinit var mBtnLoc: Button
    private lateinit var mBtnShare: Button
    private lateinit var mBtnTake: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework23Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        mWebsiteEditText = binding.homework23WebsiteEdittext
        mLocationEditText = binding.homework23LocationEdittext
        mShareTextEditText = binding.homework23ShareEdittext
        mBtnUri = binding.homework23OpenWebsiteButton
        mBtnLoc = binding.homework23OpenLocationButton
        mBtnShare = binding.homework23ShareTextButton
        mBtnTake = binding.homework23TakePictureButton
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
        mBtnUri.setOnClickListener { openWebsite() }
        mBtnLoc.setOnClickListener { openLocation() }
        mBtnShare.setOnClickListener { shareText() }
        mBtnTake.setOnClickListener { takePicture() }
    }

    private fun removeOnClickListeners() {
        mBtnUri.setOnClickListener(null)
        mBtnLoc.setOnClickListener(null)
        mBtnShare.setOnClickListener(null)
        mBtnTake.setOnClickListener(null)
    }

    private fun openWebsite() {
        val url = mWebsiteEditText.text.toString()
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d(
                App.Strings.get(R.string.chapter_23_log_tag),
                App.Strings.get(R.string.chapter_23_log_msg1)
            )
        }
    }

    private fun openLocation() {
        val loc = mLocationEditText.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$loc")
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

    private fun shareText() {
        val txt = mShareTextEditText.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder(this)
            .setType(mimeType)
            .setChooserTitle(getString(R.string.chapter_23_chooser_title))
            .setText(txt)
            .startChooser()
    }

    private fun takePicture() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d(
                App.Strings.get(R.string.chapter_23_log_tag),
                App.Strings.get(R.string.chapter_23_log_msg1)
            )
        }
    }
}