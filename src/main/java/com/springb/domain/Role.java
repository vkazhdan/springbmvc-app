package com.springb.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * User role.
 */
public enum Role implements GrantedAuthority {
	USER, ADMIN;

	@Override
	public String getAuthority() {
		return this.name();
	}
}
