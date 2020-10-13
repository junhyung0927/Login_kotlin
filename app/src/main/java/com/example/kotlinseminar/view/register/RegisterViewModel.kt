package com.example.kotlinseminar.view.register

import androidx.lifecycle.MutableLiveData
import com.example.kotlinseminar.view.base.BaseViewModel
import com.example.kotlinseminar.repository.RegisterRepository
import util.SingleLiveEvent
import com.example.kotlinseminar.dto.Data
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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
}