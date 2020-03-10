package com.example.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class GatewayController {
	
	@GetMapping(path="/photo_fallback")
	public Mono<String> photoFallback() {
		
		return Mono.just("Photo Service is down");
	}

	@GetMapping(path="/mycmd_fallback")
	public Mono<String> mycmdFallback() {
		
		return Mono.just("mycmd fallback");
	}
}
