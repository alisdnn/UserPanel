package com.alisdnn.userpanel.presentation.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alisdnn.userpanel.domain.user.usecase.UserLoginParams
import com.alisdnn.userpanel.domain.user.usecase.UserLoginUseCase
import com.alisdnn.userpanel.presentation.base.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class LoginViewModel
@ViewModelInject
constructor(
    private val userLoginUseCase: UserLoginUseCase
) : BaseViewModel() {


    private val _isUserValid: MutableLiveData<Boolean> = MutableLiveData()
    val isUserValid: LiveData<Boolean> = _isUserValid

    fun checkUserValidity(username: String, password: String) {
        userLoginUseCase(UserLoginParams(mapOf("username" to username, "password" to password)))
            .observeOn(AndroidSchedulers.mainThread())
            .autoDisposable()
            .subscribe { item ->
                _isUserValid.value = item
            }
    }

}