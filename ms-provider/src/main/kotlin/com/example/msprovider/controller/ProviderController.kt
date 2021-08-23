package com.example.msprovider.controller

import com.example.msprovider.config.RemoteConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/provider")
class ProviderController {

    @Value("\${server.port}")
    var port: Int = 0

    @Autowired
    lateinit var config: RemoteConfig

    @RequestMapping("/test")
    fun test(): Any {
        return mapOf(
            "hello" to "world",
            "hello2" to config.hello,
            "msg" to "msg from provider",
            "port" to port
        )
    }
}