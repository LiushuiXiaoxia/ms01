package com.example.mscustomer.service.impl

import com.example.mscustomer.service.IProviderService
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ProviderServiceImplTest {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var service: IProviderService

    @Test
    fun testUserRestTemp() {
        val ret = service.testUserRestTemp()
        log.info("testUserRestTemp.ret = ${ret}}")
    }
}