package com.example.msprovider.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
@ConfigurationProperties(prefix = "config")
class RemoteConfig {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    var hello: String? = null

    @PostConstruct
    fun post() {
        log.info("config = $this")
    }

    override fun toString(): String {
        return "RemoteConfig(hello=$hello)"
    }
}