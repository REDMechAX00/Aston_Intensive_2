package com.redmechax00.astonintensive2.ui.main

import androidx.appcompat.app.AppCompatActivity
import com.redmechax00.astonintensive2.App
import com.redmechax00.astonintensive2.R
import com.redmechax00.astonintensive2.ui.chapter11.ChallengeActivity11
import com.redmechax00.astonintensive2.ui.chapter11.HomeworkActivity11
import com.redmechax00.astonintensive2.ui.chapter12a.ChallengeActivity12A
import com.redmechax00.astonintensive2.ui.chapter12b.ChallengeActivity12B
import com.redmechax00.astonintensive2.ui.chapter12b.HomeworkActivity12B
import com.redmechax00.astonintensive2.ui.chapter13.ChallengeActivity13
import com.redmechax00.astonintensive2.ui.chapter13.HomeworkActivity13
import com.redmechax00.astonintensive2.ui.chapter14.HomeworkActivity14
import com.redmechax00.astonintensive2.ui.chapter21.ChallengeMainActivity21
import com.redmechax00.astonintensive2.ui.chapter21.HomeworkMainActivity21
import com.redmechax00.astonintensive2.ui.chapter22.ChallengeMainActivity22
import com.redmechax00.astonintensive2.ui.chapter22.HomeworkActivity22
import com.redmechax00.astonintensive2.ui.chapter23.ChallengeMainActivity23
import com.redmechax00.astonintensive2.ui.chapter23.HomeworkActivity23

class TasksFactory {
    companion object {
        fun getHomework(chapterTitle: String?): AppCompatActivity? {
            return when (chapterTitle) {
                App.Strings.get(R.string.title_chapter_1_1) -> HomeworkActivity11()
                App.Strings.get(R.string.title_chapter_1_2_B) -> HomeworkActivity12B()
                App.Strings.get(R.string.title_chapter_1_3) -> HomeworkActivity13()
                App.Strings.get(R.string.title_chapter_1_4) -> HomeworkActivity14()
                App.Strings.get(R.string.title_chapter_2_1) -> HomeworkMainActivity21()
                App.Strings.get(R.string.title_chapter_2_2) -> HomeworkActivity22()
                App.Strings.get(R.string.title_chapter_2_3) -> HomeworkActivity23()
                else -> null
            }
        }

        fun getChallenge(chapterTitle: String?): AppCompatActivity? {
            return when (chapterTitle) {
                App.Strings.get(R.string.title_chapter_1_1) -> ChallengeActivity11()
                App.Strings.get(R.string.title_chapter_1_2_A) -> ChallengeActivity12A()
                App.Strings.get(R.string.title_chapter_1_2_B) -> ChallengeActivity12B()
                App.Strings.get(R.string.title_chapter_1_3) -> ChallengeActivity13()
                App.Strings.get(R.string.title_chapter_2_1) -> ChallengeMainActivity21()
                App.Strings.get(R.string.title_chapter_2_2) -> ChallengeMainActivity22()
                App.Strings.get(R.string.title_chapter_2_3) -> ChallengeMainActivity23()
                else -> null
            }
        }
    }
}