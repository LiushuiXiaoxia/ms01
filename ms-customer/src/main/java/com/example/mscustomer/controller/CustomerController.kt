package com.example.mscustomer.controller

import com.example.mscustomer.service.IProviderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    lateinit var service: IProviderService

    @RequestMapping("/test")
    fun test(): Any {
        return mapOf<String, Any>(
            "hello" to "world",
            "msg" to "msg from customer"
        )
    }

    @RequestMapping("/test2")
    fun test2(): Any? {
        return service.testUseRestTemp()
    }

    @RequestMapping("/test3")
    fun test3(): Any? {
        return service.testUseRestTemp()
    }
}