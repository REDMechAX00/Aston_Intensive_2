package com.redmechax00.astonintensive2.utils

import android.content.Intent
import android.content.SharedPreferences
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.data.SharedPreference

fun AppCompatActivity.startChapterMenu(activity: AppCompatActivity?, chapterTitle: String) {
    if (activity != null) {
        val intent = Intent(this, activity::class.java)
        intent.putExtra(TAG_EXTRA_CHAPTER, chapterTitle)
        startActivity(intent)
    } else {
        showToast(getString(R.string.error_chapter_not_found))
    }
}

fun AppCompatActivity.startTaskActivity(activity: AppCompatActivity?, onSuccess: () -> Unit) {
    if (activity != null) {
        startActivity(Intent(this, activity::class.java))
        onSuccess()
    } else {
        showToast(getString(R.string.error_task_not_found))
    }
}

fun AppCompatActivity.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Button.setBackgroundColorFilter(newColor: Int) {
    this.background.setTint(newColor)
}

fun AppCompatActivity.checkChapterIsViewed(chapterTitle: String): Boolean {
    return checkTaskIsViewed(chapterTitle, TAG_HOMEWORK) && checkTaskIsViewed(
        chapterTitle,
        TAG_CHALLENGE
    )
}

fun AppCompatActivity.checkTaskIsViewed(chapterTitle: String, taskType: String): Boolean {
    //Exception for simple task Chapters
    if (chapterTitle == App.Strings.get(R.string.title_chapter_1_2_A) && taskType == TAG_HOMEWORK) return true
    if (chapterTitle == App.Strings.get(R.string.title_chapter_1_4) && taskType == TAG_CHALLENGE) return true

    return SharedPreference(this).sharedPref.getBoolean(chapterTitle + taskType, false)
}

fun AppCompatActivity.clearViewedHistory(): Boolean {
    val editor: SharedPreferences.Editor = SharedPreference(this).sharedPref.edit()
    val homeworkEntries: Map<String, *> = SharedPreference(this).sharedPref.all
        .filter { it.key.indexOf(TAG_HOMEWORK) != -1 }
    for (entry: Map.Entry<String, *> in homeworkEntries.entries) {
        editor.remove(entry.key)
    }
    val challengeEntries: Map<String, *> = SharedPreference(this).sharedPref.all
        .filter { it.key.indexOf(TAG_CHALLENGE) != -1 }
    for (entry: Map.Entry<String, *> in challengeEntries.entries) {
        editor.remove(entry.key)
    }
    editor.apply()
    return false
}