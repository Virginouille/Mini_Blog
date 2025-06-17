package com.mini.blog.service;

import com.mini.blog.model.Article;
import com.mini.blog.model.Utilisateurs;
import com.mini.blog.repository.ArticleRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    //Méthode quand utilisateur est un auteur
    /**Méthode pour la création d'un article*/
    public Article createArticle(Article article) {

        if (article.getTitle() == null || article.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("The title cannot be empty");
        }

        if (article.getContent() == null || article.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("The content cannot be empty");
        }

        if (article.getPublished() == null) {
            article.setPublished(LocalDateTime.now());
        }

        if(article.getAuthorId() == null){
            Utilisateurs currentUser = getCurrentAutheticatedUser();
            if (currentUser != null) {
                article.setAuthorId(currentUser.getId());

            } else {
                throw new IllegalArgumentException("Unable to create an article without an author");
            }
        }

        return articleRepository.save(article);

    }

    /**Méthode pour la modification d'un article*/
    public Article modifyArticle(Long idArticle, String title, String content) {

        Article existingArticle = articleRepository.findById(idArticle)
                .orElseThrow(() -> new IllegalArgumentException("Article with id : " + idArticle + " not found"));

        existingArticle.setTitle(title);
        existingArticle.setContent(content);

        return articleRepository.save(existingArticle);
    }

    /**Méthode pour supprimer un article*/
    public void deleteArticle(Long idArticle) {
        Article existingArticle = articleRepository.findById(idArticle)
                .orElseThrow(() -> new IllegalArgumentException("Article with id : " + idArticle + " not found"));

        articleRepository.delete(existingArticle);
    }

    /**Méthode pour récupérer tous les articles*/
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

}
