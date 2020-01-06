package com.microservice.atm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.atm.model.CountH;

import reactor.core.publisher.Mono;

public class AtmController {
	
	
	@PutMapping("/retirecounth/{dni}")
	public Mono<ResponseEntity<CountH>> updateretire(@RequestBody CountH counth, @PathVariable String dni) {
		return null;

	}

}
