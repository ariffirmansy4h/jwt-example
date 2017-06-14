package com.bpr.route.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import com.bpr.route.Users.AccountCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    
    private static final Logger logger = LoggerFactory.getLogger(JWTLoginFilter.class);

    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        logger.info("JWTLoginFilter");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
        logger.info("attemptAuthentication");
        AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);

        return getAuthenticationManager().authenticate(
            new UsernamePasswordAuthenticationToken(
                creds.getUsername(),
                creds.getPassword(),
                Collections.emptyList()
            )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException 
    {
        logger.info("successfulAuthentication");
        TokenAuthenticationService.addAuthentication(res, auth.getName());
    }
}