package com.example.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel: ViewModel() {
    private val questionBank = listOf(
        Question(R.string.question_china, true),
        Question(R.string.question_taiyuan, false),
        Question(R.string.question_xian, true),
    )
    var currentIndex = 0
    var isCheater = false

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToText() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}