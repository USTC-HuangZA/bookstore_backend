package com.reins.bookstore.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static String getCurrentUsername(){
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getCredentials());
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return (String) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
