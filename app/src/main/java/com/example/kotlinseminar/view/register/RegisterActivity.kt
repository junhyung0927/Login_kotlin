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

        registerViewModel.apply {
            this.buttonLogin.observe(this@RegisterActivity, {
                this.getRegiserData()
            })

            this.buttonAdd.observe(this@RegisterActivity, {
                val intent = Intent(this@RegisterActivity, RegisterAddActivity::class.java)
                startActivity(intent)
            })

            this.registerDataResult.observe(this@RegisterActivity, {

                if (it.get(0).username == "chojunhyung" && it.get(0).password.equals("1234")) {
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    startActivity(intent)
                }
            })
        }
    }
}