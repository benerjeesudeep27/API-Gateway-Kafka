package com.api.gateway.filter;

import java.util.*;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;
@Component
public class APIGatewayFilter implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
		Set<String> key = headers.keySet();
		key.forEach(k ->{
			List<String> values = headers.get(k);
			System.out.print(k+" : ");
			System.out.println(values);
			System.out.println("---------------------");
			
		});
		return chain.filter(exchange);
	}

}
