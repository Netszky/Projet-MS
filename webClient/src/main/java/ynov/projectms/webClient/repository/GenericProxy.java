package ynov.projectms.webClient.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import ynov.projectms.webClient.CustomProperties;

@Repository
public class GenericProxy {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	protected CustomProperties props;
}
