package com.codecool.springdidemo.comment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @GetMapping("/articles/{articleId}/comments")
    public List<CommentDTO> get(@PathVariable String articleId){
        return null;
    }

}
