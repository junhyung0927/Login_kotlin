package com.example.kotlinseminar.view.register

import androidx.lifecycle.MutableLiveData
import com.example.kotlinseminar.view.base.BaseViewModel
import com.example.kotlinseminar.repository.RegisterRepository
import util.SingleLiveEvent
import com.example.kotlinseminar.dto.RegisterAddData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterAddViewModel : BaseViewModel() {
    val registerRepository = RegisterRepository()
    val addResult = MutableLiveData<RegisterAddData>()

//    val id : MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//    val password : MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//    val name : MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }
//    val phoneNumber : MutableLiveData<String> by lazy {
//        MutableLiveData<String>()
//    }

    val id = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")
    val name = MutableLiveData<String>("")
    val phoneNumber = MutableLiveData<String>("")

    val buttonFinish = SingleLiveEvent<Unit>()

    fun buttonAddListener() =
        buttonFinish.call()

    fun addRegisterData() {
        compositeDisposable.add(
            registerRepository.getRegisterAddData(id.value, password.value, name.value, phoneNumber.value)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    addResult.postValue(it)
                })
                {
                    println("회원가입 실패입니다.")
                }
        )
    }
}