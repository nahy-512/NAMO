package com.example.namo.Floating.Schedule

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.namo.databinding.ActivityAlertPopupBinding

class AlertActivity : AppCompatActivity() {

    lateinit var binding: ActivityAlertPopupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlertPopupBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

    }
}