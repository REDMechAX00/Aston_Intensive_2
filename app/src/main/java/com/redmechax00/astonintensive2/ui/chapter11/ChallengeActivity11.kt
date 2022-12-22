package com.redmechax00.astonintensive2.ui.chapter11

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R

class ChallengeActivity11 : AppCompatActivity() {

    companion object {
        private const val LOG_TAG_EXCEPTION = "log_e"
    }

    internal class TheBirthdayHasAlreadyPassedException : Exception()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_11)

        tryHappyBirthday()
    }

    @Throws(TheBirthdayHasAlreadyPassedException::class)
    fun happyBirthday() {
        throw TheBirthdayHasAlreadyPassedException()
    }

    private fun tryHappyBirthday() {
        try {
            happyBirthday()
        } catch (e: TheBirthdayHasAlreadyPassedException) {
            e.printStackTrace()
            e(App.Strings.get(R.string.chapter_11_happy_birthday_error), e)
        }
    }

    private fun e(message: String, e: Throwable) {
        Log.e(LOG_TAG_EXCEPTION, message, e)
    }
}