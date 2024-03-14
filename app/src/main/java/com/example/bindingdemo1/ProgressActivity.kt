package com.example.bindingdemo1

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.bindingdemo1.databinding.ProgressMainBinding

class ProgressActivity: AppCompatActivity() {

    private lateinit var binding: ProgressMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.progress_main)
        binding.controlButton.setOnClickListener {
            binding.apply {
                if (progressBar.visibility == View.GONE) {
                    progressBar.visibility = View.VISIBLE
                    controlButton.text = "Stop"
                } else {
                    progressBar.visibility = View.GONE
                    controlButton.text = "Start"
                }
            }
        }
    }


}