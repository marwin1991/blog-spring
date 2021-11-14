package com.codecool.springdidemo.comment;

import com.codecool.springdidemo.article.Article;
import com.codecool.springdidemo.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    public List<Comment> get(long articleId){
        return articleRepository.findById(articleId).orElseThrow().getComments();
    }

    public Comment get(long articleId, long commentId){
        Comment comment = commentRepository.getById(commentId);
        if(comment.getArticle().getId() != articleId){
            throw new IllegalArgumentException("Wrong article ID!");
        }

        return comment;
    }

    public Comment create(long articleId, Comment comment){
        Article article = articleRepository.getById(articleId);
        article.addComment(comment);
        commentRepository.save(comment);
        return comment;
    }

    public Comment modify(long articleId, long commentId, Comment newData){
        Comment commentFromDb = commentRepository.getById(commentId);
        if(commentFromDb.getArticle().getId() != articleId){
            throw new IllegalArgumentException("Wrong article ID!");
        }
        commentFromDb.modify(newData);
        commentRepository.save(commentFromDb);
        return commentFromDb;
    }

    public void delete(long articleId, long commentId){
        Comment commentFromDb = commentRepository.getById(commentId);
        if(commentFromDb.getArticle().getId() != articleId){
            throw new IllegalArgumentException("Wrong article ID!");
        }
        commentRepository.delete(commentFromDb);
    }
}
