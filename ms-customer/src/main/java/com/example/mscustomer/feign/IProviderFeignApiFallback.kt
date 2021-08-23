package com.example.mscustomer.feign

import org.springframework.stereotype.Component

@Component
class IProviderFeignApiFallback : IProviderFeignApi {

    override fun test(): Any {
        return mapOf(
            "hello" to "failback"
        )
    }
}