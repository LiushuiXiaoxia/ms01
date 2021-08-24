package com.example.msgateway.filter

import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import java.net.URI


@Component
class BeforeFilter : AbsFilter() {

    override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
        val uri: URI = exchange.request.uri
        val gatewayUri = exchange.attributes[GATEWAY_REQUEST_URL_ATTR]
        log.info("> BeforeFilter.uri = {}, gatewayUri = {}", uri, gatewayUri)

        return chain.filter(exchange).then(Mono.fromRunnable {
            log.info("<<< After BeforeFilter.uri = {}", uri)
        })
    }

    override fun getOrder(): Int = -1
}