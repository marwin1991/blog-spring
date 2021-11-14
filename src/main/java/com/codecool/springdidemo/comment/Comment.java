package com.codecool.springdidemo.comment;

import com.codecool.springdidemo.article.Article;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Comment {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="COMMENT_SEQ")
    private Long id;

    @ManyToOne
    private Article article;

    private String content;
    private String author;
    private LocalDateTime creationDateTime;
    private LocalDateTime modifyDateTime;

}
