package com.example.msgateway.filter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils
import org.springframework.core.Ordered
import org.springframework.http.HttpStatus
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import java.net.URI

abstract class AbsFilter : GlobalFilter, Ordered {

    val log: Logger = LoggerFactory.getLogger(javaClass)

    fun dispatch(
        module: String,
        newUri: URI,
        exchange: ServerWebExchange,
        chain: GatewayFilterChain
    ): Mono<Void> {
        log.info(">>> Proxy {} newUri = {}", module, newUri)

        exchange.attributes[ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR] = newUri
        return chain.filter(exchange).then(Mono.fromRunnable {
            log.info("<<< Post $module")
        })
    }

    fun returnError(
        module: String,
        exchange: ServerWebExchange,
        status: HttpStatus
    ): Mono<Void> {
        exchange.response.statusCode = status
        return exchange.response.setComplete().then(Mono.fromRunnable {
            log.info("<<< $module return error $status ")
        })
    }
}