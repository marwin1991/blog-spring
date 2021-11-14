package com.codecool.springdidemo.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ArticleService {

    private final ArticleRepository repository;

    @Autowired
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public List<Article> getAll(){
        return repository.findArticlesByTitleStartingWithOrderById("Ala");
    }

    public Article get(long id){
        return repository.findById(id).orElseThrow();
    }

    public Article create(Article article){
        return repository.save(article);
    }

    public Article update(long id, Article article){
        Article articleFromDb = get(id);
        articleFromDb.setTitle(article.getTitle());
        return repository.save(articleFromDb);
    }

    public void delete(long id){
        repository.delete(get(id));
    }

}
