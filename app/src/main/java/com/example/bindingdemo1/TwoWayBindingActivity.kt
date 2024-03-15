package com.example.bindingdemo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bindingdemo1.databinding.TwoWayBindingBinding

class TwoWayBindingActivity: AppCompatActivity() {

    private lateinit var binding: TwoWayBindingBinding
    private lateinit var viewModel: TwoWayBindingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.two_way_binding)
        viewModel = ViewModelProvider(this)[TwoWayBindingViewModel::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
    }
}

class TwoWayBindingViewModel: ViewModel() {
    val userName = MutableLiveData<String>()

    init {
        userName.value = "Frank"
    }
}