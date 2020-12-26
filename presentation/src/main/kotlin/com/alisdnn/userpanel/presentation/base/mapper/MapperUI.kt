package com.alisdnn.userpanel.presentation.base.mapper

interface MapperUI<DomainObject, UIObject> {

    fun mapToUI(obj: DomainObject): UIObject

}