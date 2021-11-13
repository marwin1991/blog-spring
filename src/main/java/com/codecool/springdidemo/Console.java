package com.codecool.springdidemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Console {

    private final ArticleService service;

    @Autowired
    public Console(ArticleService service) {
        this.service = service;
    }

    @PostConstruct
    public void print(){
        System.out.println("Hello world");
        System.out.println(service.getAll());
    }
}
