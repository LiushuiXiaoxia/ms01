package com.example.mscustomer.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController {

    @RequestMapping("/test")
    fun test(): Any {
        return mapOf<String, Any>(
            "hello" to "world",
            "msg" to "msg from customer"
        )
    }
}