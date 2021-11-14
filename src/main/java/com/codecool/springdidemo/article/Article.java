package com.codecool.springdidemo.article;

import com.codecool.springdidemo.comment.Comment;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Article {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    private long id;

    @Column(name = "some_title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="article_id")
    private List<Comment> comments;

    private String content;

    private String author;

    public void addComment(Comment comment){
        comment.setCreationDateTime(LocalDateTime.now());
        comment.setModifyDateTime(null);
        this.comments.add(comment);
        comment.setArticle(this);
    }

}
