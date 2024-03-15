package com.example.bindingdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bindingdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
//        viewModel.startingCount.observe(this, Observer {
//            binding.greetingTextView.text = it.toString()
//        })

//        binding.submitButton.setOnClickListener {
//            viewModel.increment()
//        }
    }
}

class MainActivityViewModel: ViewModel() {
    var startingCount = MutableLiveData<Int>()

    init {
        startingCount.value = 0
    }

    fun increment() {
        startingCount.value = (startingCount.value)?.plus(1)
    }
}