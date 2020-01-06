package com.microservice.atm.services;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.atm.model.CountH;
import com.microservice.atm.model.CurrentAccount;


import reactor.core.publisher.Mono;

@Service
public class AtmServiceImp implements AtmServices {
	

	
	@Autowired
	@Qualifier("CurrentR")
	WebClient clientCurrentR;
	
	@Autowired
	@Qualifier("CurrentD")
	WebClient clientCurrentD;
	
	@Autowired
	@Qualifier("CounthR")
	WebClient clientCounthR;
	
	@Autowired
	@Qualifier("CounthD")
	WebClient clientCounthD;
	
	

	
	
	@SuppressWarnings("deprecation")
	public Mono<CountH> retireCount(CountH client, String dni) {
		return clientCounthR.put().uri("/"+dni)
				// http://localhost:8090/apicounth/retire/dni/{dni}
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(producto))
	
				.syncBody(client)
				.retrieve()
				.bodyToMono(CountH.class);
	}

	@SuppressWarnings("deprecation")
	public Mono<CountH> depositeCount(CountH client,String dni) {
		return clientCounthD.put().uri("/"+dni)
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(producto))
				.syncBody(client)
				.retrieve()
				.bodyToMono(CountH.class);
	}
	
	@SuppressWarnings("deprecation")
	public Mono<CurrentAccount> retireCurrent(CurrentAccount client, String dni) {
		return clientCurrentR.put().uri("/"+dni)
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(producto))
				.syncBody(client)
				.retrieve()
				.bodyToMono(CurrentAccount.class);
	}

	@SuppressWarnings("deprecation")
	public Mono<CurrentAccount> depositeCurrent(CurrentAccount client, String dni) {
		return clientCurrentD.put().uri("/"+dni)
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(producto))
				.syncBody(client)
				.retrieve()
				.bodyToMono(CurrentAccount.class);
	}
	

}
