package com.example.msgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication(
    exclude = [RedisAutoConfiguration::class]
)
class MsGatewayApplication

fun main(args: Array<String>) {
    runApplication<MsGatewayApplication>(*args)
}
