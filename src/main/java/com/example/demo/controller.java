package com.example.demo;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class controller {
	
	@RequestMapping("/brokers")
	public String hello() {
		return "Encontrado com sucesso!";
	}
	
	@GetMapping (value = "/callvalidationbroker")
	private String getCorretor() {
		String uri = "http://localhost:8080/brokers";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
		
	}
	
	@GetMapping(value = "/broker")
	public List<Object> getBroker() {
		String url = "https://607732991ed0ae0017d6a9b0.mockapi.io/insurance/v1/brokerData";
		RestTemplate restTemplate = new RestTemplate();
		
		Object[] broker = restTemplate.getForObject(url, Object[].class);
		return Arrays.asList(broker);
	}
	
}
