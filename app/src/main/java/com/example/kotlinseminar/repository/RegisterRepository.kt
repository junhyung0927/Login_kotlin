package com.example.kotlinseminar.repository

import com.example.kotlinseminar.service.RegisterRetrofit
import com.example.kotlinseminar.service.RegisterService
import com.example.kotlinseminar.dto.Data
import com.example.kotlinseminar.dto.RegisterAddData
import io.reactivex.Observable
import kotlin.collections.HashMap


class RegisterRepository {
    val registerService: RegisterService =
        RegisterRetrofit().getInstance().create(RegisterService::class.java)

    fun getRegisterAddData(
        id: String?,
        password: String?,
        name: String?,
        phoneNumber: String?
    ) = registerService.addRegister(HashMap<String, Any?>().apply {
            put("id", id)
            put("password", password)
            put("name", name)
            put("phoneNumber", phoneNumber)
        })

    fun getRegisterData(): Observable<List<Data>> {
        return registerService.requestLogin()
    }
}
