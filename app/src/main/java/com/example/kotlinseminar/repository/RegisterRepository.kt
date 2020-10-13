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
    ): Observable<RegisterAddData>{

        val input = HashMap<String, Any?>()
        input.put("id", id)
        input.put("password", password)
        input.put("name", name)
        input.put("phoneNumber", phoneNumber)
        return registerService.addRegister(input)
    }

    fun getRegisterData() : Observable<List<Data>> {
        return registerService.requestLogin()
    }
}
