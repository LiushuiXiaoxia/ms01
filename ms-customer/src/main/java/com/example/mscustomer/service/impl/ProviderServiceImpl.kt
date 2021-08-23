package com.example.mscustomer.service.impl

import com.example.mscustomer.service.IProviderService
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ProviderServiceImpl : IProviderService {

    override fun testUserRestTemp(): Any? {
        val temp = RestTemplate()
        val resp = temp.getForEntity("http://localhost:8820/provider/test", Any::class.java)
        return resp.body
    }
}