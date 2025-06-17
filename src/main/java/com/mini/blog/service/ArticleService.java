package com.mini.blog.service;

import com.mini.blog.model.Article;
import com.mini.blog.model.Utilisateurs;
import com.mini.blog.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    //Méthode quand utilisateur est un auteur
    /**Méthode pour la création d'un article*/
    public Article createArticle(String title, String content, Utilisateurs author, LocalDate publicationDate) {
        Article article = new Article();

        article.setTitle(title);
        article.setContent(content);

        article.setAuthorId(author.getId());

        article.setPublished(publicationDate.atStartOfDay());

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
