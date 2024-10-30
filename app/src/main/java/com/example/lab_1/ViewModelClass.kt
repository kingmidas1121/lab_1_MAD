package com.example.lab_1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData


class ViewModelClass: ViewModel(){

private val _text = MutableLiveData<String>()
val text: LiveData<String> = _text

private lateinit var randomTexts: List<String>

fun setTexts(texts: List<String>) {
    randomTexts = texts
}

fun changeText() {
    val currentText = _text.value
    var newText: String?

    do {
        newText = randomTexts.random()
    } while (newText == currentText)
    _text.value = newText
}
}