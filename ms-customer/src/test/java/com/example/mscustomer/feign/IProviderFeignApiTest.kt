package com.example.mscustomer.feign

import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class IProviderFeignApiTest {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var api: IProviderFeignApi

    @Test
    fun test() {
        val ret = api.test()
        log.info("ret = $ret")
    }
}