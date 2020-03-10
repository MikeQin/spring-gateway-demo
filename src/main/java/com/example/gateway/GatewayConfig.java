package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/api/v1/**")
						.filters(f -> f.addRequestHeader("gateway-route", "photo service")
								.hystrix(config -> config.setName("photo-service").setFallbackUri("forward:/photo_fallback")))
						.uri("https://amazefoto-photo-dev.cfdev01-tx-a.iteclientsys.local"))
				.build();
	}

}
