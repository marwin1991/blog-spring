package com.codecool.springdidemo.article;

public class ArticleDTO { //ArticleRequest, ArticleResponse
    private long id;
    private String title;

    public Article toArticle(){
        return new Article(getId(), getTitle());
    }

    public static ArticleDTO of(Article article){
        return new ArticleDTO(article.getId(), article.getTitle());
    }

    public ArticleDTO() {
    }

    public ArticleDTO(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
