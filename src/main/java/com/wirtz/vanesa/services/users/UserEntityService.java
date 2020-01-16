package com.wirtz.vanesa.services.users;

import java.util.Optional;

import com.wirtz.vanesa.persistence.users.model.UserEntity;
import com.wirtz.vanesa.persistencia.users.repos.UserEntityRepository;
import com.wirtz.vanesa.services.base.BaseService;

public class UserEntityService 
		extends BaseService<UserEntity, Long, UserEntityRepository>{

	public Optional<UserEntity> findByUsername(String username){
		return repository.findByUsername(username);
	}
}
