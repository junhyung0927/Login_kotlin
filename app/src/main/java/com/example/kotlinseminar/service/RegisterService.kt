package com.example.kotlinseminar.service

import com.example.kotlinseminar.dto.Data
import com.example.kotlinseminar.dto.RegisterAddData
import com.example.kotlinseminar.dto.TestData
import io.reactivex.Observable
import retrofit2.Callback
import retrofit2.http.*


interface RegisterService {

    @GET("/data")
    fun requestTest(
        @Query("count") count: String
    ): Observable<List<TestData?>?>?

    @GET("/data")
    fun requestTest2(): Observable<List<TestData>>

    @GET("/test")
    fun requestLogin(): Observable<List<Data>>

    @POST("/test")
    fun addRegister(
        @Body param: HashMap<String, Any?>
    ): Observable<RegisterAddData>
}