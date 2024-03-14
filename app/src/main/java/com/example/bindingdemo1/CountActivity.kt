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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.count_activity)
        viewModel = ViewModelProvider(this).get(CountActivityViewModel::class.java)

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

class CountActivityViewModel: ViewModel() {

    private var count: Int = 0

    fun getCount(): Int {
       return count
    }

    fun incrementCount(increment: Int): Int {
        count += increment
        return count
    }

}