package com.codecool.springdidemo.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO { //ArticleRequest, ArticleResponse
    private long id;
    private String title;

    public Article toArticle(){
        return Article.builder()
                .id(id)
                .title(title)
                .build();
    }

    public static ArticleDTO of(Article article){
        return new ArticleDTO(article.getId(), article.getTitle());
    }
}
