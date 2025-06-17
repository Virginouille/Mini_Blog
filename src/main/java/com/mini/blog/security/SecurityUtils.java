package com.mini.blog.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;


public class SecurityUtils {

    /**Méthode utils qui permet de vérifer si un utilisateur est anonyme*/
    public static boolean isAnonymousUser(Authentication authentication) {
        return authentication.getPrincipal() == null
                || !authentication.isAuthenticated()
                || (authentication.getPrincipal() instanceof String
        && "anonymousUser".equals(authentication.getPrincipal()));
    }
}
