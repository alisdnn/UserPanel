package com.alisdnn.userpanel.domain.user.usecase

import com.alisdnn.userpanel.domain.base.usecase.SingleUseCase
import com.alisdnn.userpanel.domain.user.repository.UserRepository
import com.alisdnn.userpanel.domain.util.Constants
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLoginUseCase @Inject constructor(
    private val userRepository: UserRepository
) : SingleUseCase<Boolean, UserLoginParams> {

    override fun invoke(params: UserLoginParams): Single<Boolean> {

        val enteredUsername = params.credentials["username"]
        val enteredPassword = params.credentials["password"]

        if (enteredUsername == Constants.ADMIN_USERNAME
            && enteredPassword == Constants.ADMIN_PASSWORD
        ) {
            return Single.just(true)
        }

        enteredUsername?.let {
            userRepository.getUser(it).map { user ->
                if (user.password == enteredPassword)
                    return@map Single.just(true)
                else {
                    return@map Single.just(false)
                }
            }
        }

        return Single.just(false)

    }

}

inline class UserLoginParams(val credentials: Map<String, String>)
