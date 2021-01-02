package com.alisdnn.userpanel.presentation.signup

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alisdnn.userpanel.domain.user.usecase.UserSignupParams
import com.alisdnn.userpanel.domain.user.usecase.UserSignupUseCase
import com.alisdnn.userpanel.presentation.base.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class SignupViewModel @ViewModelInject constructor(
    private val userSignupUseCase: UserSignupUseCase
) : BaseViewModel() {

    private val _isUserAdmin: MutableLiveData<Boolean> = MutableLiveData()
    val isUserAdmin: LiveData<Boolean> = _isUserAdmin

    fun signupUser(
        username: String,
        fullname: String,
        password: String
    ) {
        userSignupUseCase(
            UserSignupParams(
                mapOf(
                    "username" to username,
                    "fullname" to fullname,
                    "password" to password
                )
            )
        ).observeOn(AndroidSchedulers.mainThread())
            .autoDisposable()
            .subscribe { user ->
                _isUserAdmin.value = user.isAdmin
            }
    }
}