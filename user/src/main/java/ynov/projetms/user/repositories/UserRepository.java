package ynov.projetms.user.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ynov.projetms.user.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
}
