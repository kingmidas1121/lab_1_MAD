package com.example.lab_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.TextView
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import android.graphics.Color

class MainActivity : ComponentActivity() {
    private val viewModel: ViewModelClass by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        val textView = findViewById<TextView>(R.id.text1)
        val button = findViewById<Button>(R.id.button2)

        val randomTexts = listOf(
            getString(R.string.text1),
            getString(R.string.text2),
            getString(R.string.text3),
            getString(R.string.text4),
            getString(R.string.text5)
        )
        val colors = listOf(
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.MAGENTA,
            Color.CYAN
        )
        viewModel.setTexts(randomTexts)
        viewModel.text.observe(this, Observer { newText ->
            textView.text = newText
        })
        button.setOnClickListener {
            viewModel.changeText()
            val randomColor = colors.random()
            textView.setTextColor(randomColor)
        }
    }
}

