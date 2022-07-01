package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatPic getPic() {
		CatPic catPic = null;
		try{
			catPic = restTemplate.getForObject("https://cat-data.netlify.app/api/pictures/random", CatPic.class);
		}catch (RestClientResponseException e) {
			System.out.println("Error 1");
		} catch (ResourceAccessException e) {
			System.out.println("Error 2");
		}

		return catPic;
	}

}	
