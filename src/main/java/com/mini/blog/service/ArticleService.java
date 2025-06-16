package com.mini.blog.service;

import com.mini.blog.model.Article;
import com.mini.blog.model.Utilisateurs;
import com.mini.blog.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    //Méthode quand utilisateur est un auteur
    public Article createArticle(String title, String content, Utilisateurs author, LocalDate publicationDate) {
        Article article = new Article();

        article.setTitle(title);
        article.setContent(content);

        article.setAuthorId(author.getId());

        article.setPublished(publicationDate.atStartOfDay());

        return articleRepository.save(article);

    }
}
