package com.mini.blog.controller;

import com.mini.blog.model.Article;
import com.mini.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")

public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //Post d'un article
    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        Article savedArticle = articleService.createArticle(article);
                return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    //Récupération de tous les articles
    @GetMapping
    public List<Article> getArticles() {
        return articleService.getAllArticles();
    }
}
