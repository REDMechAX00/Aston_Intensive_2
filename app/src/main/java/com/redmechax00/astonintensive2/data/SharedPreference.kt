package com.redmechax00.astonintensive2.data

import android.content.Context
import android.content.SharedPreferences
import com.redmechax00.astonintensive2.utils.PREFS_NAME

class SharedPreference(private val context: Context) {
    val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
}