package com.example.kotlinseminar.view.register

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinseminar.view.base.BaseActivity
import com.example.kotlinseminar.R
import com.example.kotlinseminar.databinding.ActivityRegisterAddBinding

class RegisterAddActivity : BaseActivity(){
    private val binding by binding<ActivityRegisterAddBinding>(R.layout.activity_register_add)
    private lateinit var registerAddViewModel: RegisterAddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerAddViewModel = ViewModelProviders.of(this).get(
            RegisterAddViewModel::class.java
        )

        binding.apply {
            lifecycleOwner = this@RegisterAddActivity
            addViewModel = registerAddViewModel
        }

        registerAddViewModel.addRegisterData()
        registerAddViewModel.buttonFinish.observe(this, {
            val intent = Intent(this , RegisterActivity::class.java)
            startActivity(intent)
        })
    }
}