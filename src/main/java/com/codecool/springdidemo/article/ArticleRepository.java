package com.codecool.springdidemo.article;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ArticleRepository {

    private final List<Article> articles = Arrays.asList(
            new Article(1, "Article 1"),
            new Article(2, "Article 2")
    );

    public List<Article> getAll() {
        return articles;
    }
}
