package com.wirtz.vanesa.services.users;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service("userDetailsService")
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService{

	private final UserEntityService userEntityService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userEntityService.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(username + "no encontrado"));
	}

}
