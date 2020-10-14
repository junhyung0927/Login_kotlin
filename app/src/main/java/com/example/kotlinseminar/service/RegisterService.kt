package com.example.kotlinseminar.service

import com.example.kotlinseminar.dto.Data
import com.example.kotlinseminar.dto.RegisterAddData
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import kotlin.collections.HashMap

interface RegisterService {

    @GET("/get")
    fun requestLogin() : Observable<List<Data>>

    @POST("/post")
    fun addRegister(
        @Body param: HashMap<String, Any?>
    ): Observable<RegisterAddData>
}