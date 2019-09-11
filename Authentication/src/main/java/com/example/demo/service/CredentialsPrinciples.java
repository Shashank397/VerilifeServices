package com.example.demo.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.Credentials;

public class CredentialsPrinciples implements UserDetails {

	private Credentials cred;
	
	
	public CredentialsPrinciples(Credentials cred) {
		super();
		this.cred = cred;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("CREDENTIALS"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return cred.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return cred.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
