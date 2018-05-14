package br.com.viridis.security;

import javax.servlet.http.HttpServletRequest;

public class AuthenticateService implements IAuthenticateService {

	/**
	 * É o nome do parametro no header que é usado para a autenticação.
	 */
	private static final String NAME_PARAMETER_HASH = "hash-autenticacao-viridis";
	
	/**
	 * Hash utilizado como referencia para autenticacao. É o SHA-1".
	 */
	private static final String HASH_VALID_AUTHENTICATION = "da39a3ee5e6b4b0d3255bfef95601890afd80709";

	@Override
	public boolean authenticate(HttpServletRequest request) {
		
		String header = request.getHeader(NAME_PARAMETER_HASH);
		
		if (header == null || header.isEmpty()) {
			return false;
		}

		return HASH_VALID_AUTHENTICATION.equals(header);
	
	}
}
