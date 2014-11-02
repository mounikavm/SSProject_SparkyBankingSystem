package com.group10.sparkysbank.service;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



public class RoleBasedSecurityService implements AuthenticationSuccessHandler{

	RedirectStrategy redirect;
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		redirect=new DefaultRedirectStrategy();
		if(authentication.isAuthenticated())
		{
			Collection<GrantedAuthority> list= (Collection<GrantedAuthority>) authentication.getAuthorities();
			
			for(GrantedAuthority auth:list)
			{
				if(auth.getAuthority().equals("ROLE_ADMIN") || auth.getAuthority().equals("ROLE_EMPLOYEE"))
				{
					redirect.sendRedirect(request, response, "/intHome");
				}
				
				if(auth.getAuthority().equals("ROLE_MERCHANT"))
				{
					redirect.sendRedirect(request,response, "/extHome");
				}
				if(auth.getAuthority().equals("ROLE_CUSTOMER"))
				{
					redirect.sendRedirect(request,response, "/extCustomerHome");
				}
			}
		}
		
	}

}
