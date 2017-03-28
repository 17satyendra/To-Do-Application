package com.bridgeit.toDoApp.filter;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgeit.toDoApp.json.ErrorResponse;
import com.bridgeit.toDoApp.model.Token;
import com.bridgeit.toDoApp.service.TokenService;

public class TokenBasedAuthFilter implements Filter
{

	
	@Autowired 
	TokenService tokenservice;
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		Date currentDate = new Date();
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String accessToken = request.getHeader("access_token");

		if (accessToken == null || accessToken.trim().isEmpty()) {
			Cookie[] cks = request.getCookies();
			if (cks != null) {
				for (Cookie cookie : cks) {
					if (cookie.getName().equals("access_token")) {
						accessToken = cookie.getValue();
						System.out.println(accessToken);
					}
				}
			}
		}

		if (accessToken == null || accessToken.trim().isEmpty()) {

			ErrorResponse er = new ErrorResponse();
			er.setStatus(-1);
			er.setMessage("Invalid credential, user not found");

			response.setContentType("application/json");
			String jsonResp = "{\"status\":\"-2\",\"errorMessage\":\"Invalid access token\"}";
			response.getWriter().write(jsonResp);
			return;
		}

		Token token = tokenservice.getAccessTokenByAcc(accessToken);
		if (token == null) {

			response.setContentType("application/json");
			String jsonResp = "{\"status\":\"-3\",\"errorMessage\":\"Invalid access token\"}";
			response.getWriter().write(jsonResp);
			return;
		}

		Date date = token.getCreatedOn();

		long diff = currentDate.getTime() - date.getTime();
		long diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(diff);
		if (diffInSeconds > 60) // 1min
		{
			// generate json error response - access token is expired
			response.setContentType("application/json");
			String jsonResp = "{\"status\":\"-4\",\"errorMessage\":\"Access token is expired. Generate new Access Tokens\"}";
			response.getWriter().write(jsonResp);
			return;
		}
		chain.doFilter(request, response);

	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
}
