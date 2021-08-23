package com.example.msprovider.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/provider")
class ProviderController {

    @RequestMapping("/test")
    fun test(): Any {
        return mapOf<String, Any>(
            "hello" to "world",
            "msg" to "msg from provider"
        )
    }
}