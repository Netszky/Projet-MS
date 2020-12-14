package ynov.projectms.webClient.repository;

import org.springframework.beans.factory.annotation.Autowired;

import ynov.projectms.webClient.CustomProperties;

public class UserProxy extends GenericProxy{
	
	@Autowired
	private CustomProperties props;
	
}
