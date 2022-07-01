package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatFact getFact() {
		CatFact catFact = null;
		try{
			catFact = restTemplate.getForObject("https://cat-data.netlify.app/api/facts/random", CatFact.class);
		}catch (RestClientResponseException e) {
			System.out.println("Error 1");
		} catch (ResourceAccessException e) {
			System.out.println("Error 2");
		}

		return catFact;
	}

}
