package com.example.mscustomer.service.impl

import com.example.mscustomer.feign.IProviderFeignApi
import com.example.mscustomer.service.IProviderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ProviderServiceImpl : IProviderService {

    @Autowired
    lateinit var api: IProviderFeignApi

    override fun testUseRestTemp(): Any? {
        val temp = RestTemplate()
        val resp = temp.getForEntity("http://localhost:8820/provider/test", Any::class.java)
        return resp.body
    }

    override fun testUseFeign(): Any? {
        return api.test()
    }
}