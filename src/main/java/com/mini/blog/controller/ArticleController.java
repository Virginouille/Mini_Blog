package com.mini.blog.controller;

import com.mini.blog.model.Article;
import com.mini.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/article")

public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //Récupération de tous les articles
    @GetMapping
    public List<Article> getArticles() {
        return articleService.getAllArticles();
    }
}
