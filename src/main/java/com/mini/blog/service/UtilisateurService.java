package com.mini.blog.service;

import com.mini.blog.model.Utilisateurs;
import com.mini.blog.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;


    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /**Méthode qui récupère l'utilisateur en cours*/
    public UtilisateurRepository getCurrentAutheticatedUser() {

        //Récupération de l'object authentification
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        //Verification si l'utilistateur est bel et bien authentifié
        if (auth != null || !auth.isAuthenticated() || isAnonymousUser(auth.getPrincipal())) {
    throw new IllegalStateException("No regestred user");
        }
    }
}
