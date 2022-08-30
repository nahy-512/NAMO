package com.example.namo.Floating.Todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.R
import com.example.namo.databinding.ActivityAddTodoBinding

class AddTodoActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.add_todo_frm, NewTodoFragment())
            .commitAllowingStateLoss()

        binding.addTodoDarkView.setOnClickListener {
            finish()
        }
    }
}