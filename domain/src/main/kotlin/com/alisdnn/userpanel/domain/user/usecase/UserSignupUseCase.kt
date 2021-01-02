package com.alisdnn.userpanel.domain.user.usecase

import com.alisdnn.userpanel.domain.base.usecase.SingleUseCase
import com.alisdnn.userpanel.domain.user.entity.User
import com.alisdnn.userpanel.domain.user.repository.UserRepository
import com.alisdnn.userpanel.domain.util.Constants
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserSignupUseCase @Inject constructor(
    private val userRepository: UserRepository
) : SingleUseCase<User, UserSignupParams> {

    override fun invoke(params: UserSignupParams): Single<User> {

        val enteredFullname = params.items.getValue("fullname")
        val enteredUsername = params.items.getValue("username")
        val enteredPassword = params.items.getValue("password")

        val user = User(
            isAdmin = enteredUsername == Constants.ADMIN_USERNAME
                    && enteredPassword == Constants.ADMIN_PASSWORD,
            username = enteredUsername,
            fullname = enteredFullname,
            password = enteredPassword
        )

        userRepository.insertUser(user)

        return Single.just(user)

    }

}

inline class UserSignupParams(val items: Map<String, String>)
