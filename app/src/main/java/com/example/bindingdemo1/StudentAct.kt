package com.example.bindingdemo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.bindingdemo1.databinding.StudentMainBinding

class StudentAct: AppCompatActivity() {
    private lateinit var binding: StudentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.student_main)
        binding.student = getStudent()
    }

    private fun getStudent(): Student {
        return Student(123, "Zeeshan Ahmed", "zeeshanEmail@gmail.com")
    }
}

data class Student (
    var id: Int,
    var name: String,
    var email: String
)