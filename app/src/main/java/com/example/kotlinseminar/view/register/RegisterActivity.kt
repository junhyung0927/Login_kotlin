package com.example.kotlinseminar.view.register

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinseminar.view.base.BaseActivity
import com.example.kotlinseminar.R
import com.example.kotlinseminar.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity() {
    private val binding by binding<ActivityRegisterBinding>(R.layout.activity_register)
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerViewModel = ViewModelProviders.of(this).get(
            RegisterViewModel::class.java
        )

        binding.apply {
            lifecycleOwner = this@RegisterActivity
            registerModel = registerViewModel
        }

        registerViewModel.buttonLogin.observe(this, {
            registerViewModel.getRegiserData()
        })

        registerViewModel.buttonAdd.observe(this, {
            val intent = Intent(this, RegisterAddActivity::class.java)
            startActivity(intent)
        })

        registerViewModel.registerDataResult.observe(this, {
            if (it.get(0).id.equals("chojunhyung") && it.get(0).password.equals("1234")) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        })

    }


}