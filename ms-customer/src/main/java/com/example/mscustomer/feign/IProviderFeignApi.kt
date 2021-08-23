package com.example.mscustomer.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(
    name = "providerFeignApi",
    serviceId = "ms-provider",
    configuration = [FeignConfig::class],
    fallback = IProviderFeignApiFallback::class
)
interface IProviderFeignApi {

    @RequestMapping(value = ["/provider/test"], method = [RequestMethod.POST])
    fun test(): Any
}