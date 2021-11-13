package com.codecool.springdidemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ArticleController {

    @GetMapping("/articles")
    public List<Article> get(){
        return Collections.singletonList(new Article(2, "test"));
    }

    @GetMapping("/articles/{id}")
    public Article get(@PathVariable long id){
        return new Article(id, "test");
    }

    @PostMapping("/articles")
    public Article create(@RequestBody Article article){
        System.out.println(article);
        return article;
    }

    @PutMapping("/articles/{id}")
    public Article modify(@PathVariable long id, @RequestBody Article article){
        System.out.println(id);
        System.out.println(article);
        return article;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/articles/{id}")
    public void delete(@PathVariable long id){
        System.out.println(id);
    }
}
