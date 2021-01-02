package com.alisdnn.userpanel.domain.user.usecase

import com.alisdnn.userpanel.domain.base.usecase.SingleUseCase
import com.alisdnn.userpanel.domain.user.entity.User
import com.alisdnn.userpanel.domain.user.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserSignupUseCase @Inject constructor(
    private val userRepository: UserRepository
) : SingleUseCase<User, UserSignupParams> {

    override fun invoke(params: UserSignupParams): Single<User> {

    }

}

inline class UserSignupParams(val items: Map<String, String>)
