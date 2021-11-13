package com.codecool.springdidemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private ArticleRepository repository;

    @Autowired
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public List<Article> getAll(){
        return repository.getAll();
    }

}
