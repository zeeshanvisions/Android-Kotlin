package com.example.bindingdemo1

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.bindingdemo1.databinding.SecondaryMainBinding

class SecondaryMainActivity: AppCompatActivity() {

    lateinit var binding: SecondaryMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.secondary_main)
        binding.lifecycleOwner = this
    }
}