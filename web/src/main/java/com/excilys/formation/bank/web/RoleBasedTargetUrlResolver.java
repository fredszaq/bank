package com.excilys.formation.bank.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * RoleBasedTargetUrlResolver class.
 * 
 * @author excilys
 * 
 */
public class RoleBasedTargetUrlResolver implements AuthenticationSuccessHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());
		if (roles.contains("ROLE_ADMIN")) {
			response.sendRedirect("secure/admin/admin.html");
		} else {
			response.sendRedirect("secure/user.html");
		}
	}
}
