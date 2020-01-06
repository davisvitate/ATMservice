package com.microservice.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.atm.model.CountH;
import com.microservice.atm.model.CurrentAccount;
import com.microservice.atm.services.AtmServiceImp;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/atm")
public class AtmController {
	
	@Autowired
	AtmServiceImp service;
	
	
	@PutMapping("/retirecounth/{dni}")
	public Mono<CountH> retirecounth(@RequestBody CountH counth, @PathVariable("dni") String dni) {
		return service.retireCount(counth, dni);

	}
	
	@PutMapping("/depositecounth/{dni}")
	public Mono<CountH> depositecounth(@RequestBody CountH  counth, @PathVariable("dni") String dni) {
		return service.retireCount(counth, dni);

	}
	@PutMapping("/retirecurrent/{dni}")
	public Mono<CurrentAccount> retirecurrent(@RequestBody CurrentAccount current, @PathVariable("dni") String dni) {
		return service.retireCurrent(current, dni);

	}
	@PutMapping("/depositecurrent/{dni}")
	public Mono<CurrentAccount> depositecurrent(@RequestBody CurrentAccount current, @PathVariable("dni") String dni) {
		return service.depositeCurrent(current, dni);

	}

}
