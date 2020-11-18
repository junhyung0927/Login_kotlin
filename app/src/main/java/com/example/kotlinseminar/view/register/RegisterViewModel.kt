package com.example.kotlinseminar.view.register

import androidx.lifecycle.MutableLiveData
import com.example.kotlinseminar.view.base.BaseViewModel
import com.example.kotlinseminar.repository.RegisterRepository
import util.SingleLiveEvent
import com.example.kotlinseminar.dto.Data
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class RegisterViewModel : BaseViewModel() {
    val registerRepository = RegisterRepository()

    var registerDataResult = MutableLiveData<List<Data>>()
    val buttonLogin = SingleLiveEvent<Unit>()
    val buttonAdd = SingleLiveEvent<Unit>()
    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun buttonLoginListener() =
        buttonLogin.call()

    fun buttonAddListener() =
        buttonAdd.call()

    fun getRegiserData() {
        compositeDisposable.add(
            registerRepository.getRegisterData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    registerDataResult.postValue(it)
                })
                {
                    println("에러입니다.")
                })
    }

    fun getTestData(start: Long) {
        compositeDisposable.add(
            registerRepository.getTest()
                !!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val end = System.currentTimeMillis()
                    println("걸린 시간: ${end - start}")
                })
                {
                    println("에러입니다1242314.")
                })
    }


}