package com.curso.android.app.trabajo_final_ticmas.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.curso.android.app.trabajo_final_ticmas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.compareButton.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()
            viewModel.compareStrings(text1, text2)

        }

        viewModel.comparationResult.observe(this, Observer { result ->
            binding.textView1.text = if (result.sonIguales) {
                "las cadenas son iguales!"
            } else {
                "las cadenas son diferentes"
            }
        })

    }
}

