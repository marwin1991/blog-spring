package com.codecool.springdidemo.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArticleController {

    private final ArticleService service;

    @Autowired
    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/articles")
    public List<ArticleDTO> get(){
        return service.getAll().stream()
                .map(ArticleDTO::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/articles/{id}")
    public ArticleDTO get(@PathVariable long id){
        return ArticleDTO.of(service.get(id));
    }

    @PostMapping("/articles")
    public ArticleDTO create(@RequestBody ArticleDTO dto){
        return ArticleDTO.of(service.create(dto.toArticle()));
    }

    @PutMapping("/articles/{id}")
    public ArticleDTO modify(@PathVariable long id, @RequestBody ArticleDTO dto){
        Article article = service.update(id, dto.toArticle());
        return ArticleDTO.of(article);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/articles/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
