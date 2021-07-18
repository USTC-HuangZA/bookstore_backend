package com.reins.bookstore.security.filter;


import com.reins.bookstore.entity.dto.ResultDTO;
import com.reins.bookstore.security.JwtTokenUtils;
import com.reins.bookstore.security.ResponseUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class TokenAuthenticationFilter extends BasicAuthenticationFilter {

    public TokenAuthenticationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("invoking: ==========" + request.getRequestURI());
        UsernamePasswordAuthenticationToken authentication = null;
        try {
            authentication = getAuthentication(request);
        } catch (Exception e) {
            ResponseUtils.out(response, ResultDTO.error(e.getMessage()));
        }
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            ResponseUtils.out(response, ResultDTO.error("authentication failure"));
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            token = request.getParameter("token");
        }
        if (token != null && !"".equals(token.trim())) {
            String userName = JwtTokenUtils.getUserNameFromToken(token);

            if (userName != null) {
                String[] roles = JwtTokenUtils.getUserRoleFromToken(token);
                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                for (String s : roles) {
                    authorities.add(new SimpleGrantedAuthority(s));
                }
                return new UsernamePasswordAuthenticationToken(userName, token, authorities);
            }
            return null;
        }
        return null;
    }
}
