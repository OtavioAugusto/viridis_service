package br.com.viridis.security;

import javax.servlet.http.HttpServletRequest;

public interface IAuthenticateService {

	public boolean authenticate(HttpServletRequest request);
	
}
