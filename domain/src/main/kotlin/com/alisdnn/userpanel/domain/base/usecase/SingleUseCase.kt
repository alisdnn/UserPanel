package com.alisdnn.userpanel.domain.base.usecase

import io.reactivex.Single

interface SingleUseCase<Type, in Params> {

    operator fun invoke(params: Params): Single<Type>

}