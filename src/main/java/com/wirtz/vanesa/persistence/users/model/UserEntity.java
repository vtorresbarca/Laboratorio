package com.wirtz.vanesa.persistence.users.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class UserEntity implements UserDetails{

	private static final long serialVersionUID = -4212669235641229155L;

	@Id @GeneratedValue
	private Long id;
	
	@Column(unique = true) 
	private String username;
	
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING) //para que guarde la información en el set como un string
	private Set<UserRole> roles;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@Builder.Default
	private LocalDateTime lastPasswordChangeAt = LocalDateTime.now();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream()
				.map(ur -> new SimpleGrantedAuthority("ROLE_" + ur.name()))
				.collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
