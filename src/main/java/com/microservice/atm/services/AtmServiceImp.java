package com.microservice.atm.services;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.atm.model.CountH;
import com.microservice.atm.model.CurrentAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AtmServiceImp implements AtmServices {
	
	@Autowired
	@Qualifier("Movement")
	WebClient client;
	
	@Autowired
	@Qualifier("Client")
	WebClient client1;
	
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
	public Mono<Movement> saveMSMovement(Movement movement) {
		return client.post()
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(producto))
				.syncBody(movement)
				.retrieve()
				.bodyToMono(Movement.class);
	}
	
	@SuppressWarnings("deprecation")
	public Mono<ClientPerson> saveMSClient(ClientPerson client) {
		return client1.post()
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(producto))
				.syncBody(client)
				.retrieve()
				.bodyToMono(ClientPerson.class);
	}
	
	@SuppressWarnings("deprecation")
	public Mono<CountH> retireCount(CountH client) {
		return clientCounthR.put()
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(producto))
				.syncBody(client)
				.retrieve()
				.bodyToMono(CountH.class);
	}

	@SuppressWarnings("deprecation")
	public Mono<CountH> depositeCount(CountH client) {
		return clientCounthD.put()
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(producto))
				.syncBody(client)
				.retrieve()
				.bodyToMono(CountH.class);
	}
	
	@SuppressWarnings("deprecation")
	public Mono<CurrentAccount> retireCurrent(CurrentAccount client) {
		return clientCurrentR.put()
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(producto))
				.syncBody(client)
				.retrieve()
				.bodyToMono(CurrentAccount.class);
	}

	@SuppressWarnings("deprecation")
	public Mono<CurrentAccount> depositeCurrent(CurrentAccount client) {
		return clientCurrentD.put()
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(producto))
				.syncBody(client)
				.retrieve()
				.bodyToMono(CurrentAccount.class);
	}
	

}
