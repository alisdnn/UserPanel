package com.alisdnn.userpanel.data.base

interface ResponseObject<out DomainObject : Any?> {

    fun toDomain(): DomainObject

}