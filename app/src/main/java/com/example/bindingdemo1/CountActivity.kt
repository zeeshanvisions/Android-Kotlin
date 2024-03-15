package com.example.bindingdemo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bindingdemo1.databinding.CountActivityBinding

class CountActivity: AppCompatActivity() {

    private lateinit var binding: CountActivityBinding
    private lateinit var viewModel: CountActivityViewModel
    private lateinit var viewModelFactory: CountActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.count_activity)
        viewModelFactory = CountActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory)[CountActivityViewModel::class.java]

        binding.apply {
            resultField.text = viewModel.getCount().toString()

            addButton.setOnClickListener {
                val count = editField.text.toString().toInt()
                viewModel.incrementCount(count)
                resultField.text = viewModel.getCount().toString()
                editField.setText("0")
            }
        }
    }
}

class CountActivityViewModel(startingTotal: Int): ViewModel() {

    private var count: Int = 0

    init {
        count = startingTotal
    }

    fun getCount(): Int {
       return count
    }

    fun incrementCount(increment: Int): Int {
        count += increment
        return count
    }
}

class CountActivityViewModelFactory(private val startingTotal: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountActivityViewModel::class.java)) {
            return CountActivityViewModel(startingTotal) as T
        }
        throw  IllegalArgumentException("Unknown View Model")
    }
}