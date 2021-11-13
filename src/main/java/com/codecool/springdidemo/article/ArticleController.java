package com.codecool.springdidemo.article;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ArticleController {

    @GetMapping("/articles")
    public List<ArticleDTO> get(){
        return Collections.singletonList(new ArticleDTO(2, "test"));
    }

    @GetMapping("/articles/{id}")
    public ArticleDTO get(@PathVariable long id){
        return new ArticleDTO(id, "test");
    }

    @PostMapping("/articles")
    public ArticleDTO create(@RequestBody ArticleDTO article){
        new Article(article.getId(), article.getTitle());
        System.out.println(article);
        return article;
    }

    @PutMapping("/articles/{id}")
    public ArticleDTO modify(@PathVariable long id, @RequestBody ArticleDTO article){
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
