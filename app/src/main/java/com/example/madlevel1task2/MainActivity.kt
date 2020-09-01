package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val answers = arrayOf("T", "F", "F", "F")
    private var numberOfCorrectAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Log.d("TAG", "button clicked!")
            onClickSubmit()
        }
    }

    private fun onClickSubmit() {
        val inputs = arrayOf(binding.etInput1.text,
            binding.etInput2.text,
            binding.etInput3.text,
            binding.etInput4.text)

        for (i in 0..answers.size-1) {
            Log.d("TAG", "input: '" + inputs[i] + "'")
            Log.d("TAG", "answer: '" + answers[i] + "'")
            if (inputs[i].toString().equals(answers[i].toString())) {
                numberOfCorrectAnswers++
            }
        }

        showResult()
        numberOfCorrectAnswers = 0
    }

    private fun showResult() {
        Toast.makeText(this, getString(R.string.correct, numberOfCorrectAnswers), Toast.LENGTH_SHORT).show()
    }
}