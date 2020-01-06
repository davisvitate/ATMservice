package com.microservice.atm.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

//	@Bean
//	@Qualifier("Movement")
//	public WebClient registerWebClient() {
//		return WebClient.create("http://localhost:8090/apimovement/movement/createM");
//		
//	}
//	
//	
//	@Bean
//	@Qualifier("Client")
//	public WebClient registerWebClien() {
//		return WebClient.create("http://localhost:8090/apiclient/client/createC");
//		
//	}
	
	@Bean
	@Qualifier("CounthR")
	public WebClient registerWebCounthR() {
		return WebClient.create("http://localhost:8090/apicounth/counth/retire/dni");
		
	}
	
	@Bean
	@Qualifier("CounthD")
	public WebClient registerWebCounthD() {
		return WebClient.create("http://localhost:8090/apicounth/counth/deposite/dni");		
	}
	
	@Bean
	@Qualifier("CurrentD")
	public WebClient registerWebCurrentD() {
		return WebClient.create("http://localhost:8090/apicurrent/current/deposite/dni");	
	}
	
	@Bean
	@Qualifier("CurrentR")
	public WebClient registerWebCurrentR() {
		return WebClient.create("http://localhost:8090/apicurrent/current/retire/dni");		
	}
}
