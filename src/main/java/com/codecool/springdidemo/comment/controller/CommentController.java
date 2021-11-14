package com.codecool.springdidemo.comment.controller;

import com.codecool.springdidemo.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
class CommentController {

    private final CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping("/articles/{articleId}/comments")
    public List<CommentDTO> get(@PathVariable long articleId){
        return service.get(articleId)
                .stream()
                .map(CommentDTO::of)
                .collect(Collectors.toList());
    }

    @GetMapping("/articles/{articleId}/comments/{commentId}")
    public CommentDTO get(@PathVariable long articleId, @PathVariable long commentId){
        return CommentDTO.of(service.get(articleId, commentId));
    }

    @PostMapping("/articles/{articleId}/comments")
    public CommentDTO create(@PathVariable long articleId, @RequestBody CommentDTO dto){
        return CommentDTO.of(service.create(articleId, dto.toComment()));
    }

    @PutMapping("/articles/{articleId}/comments/{commentId}")
    public CommentDTO modify(@PathVariable long articleId,
                             @PathVariable long commentId,
                             @RequestBody CommentDTO dto){
        return CommentDTO.of(service.modify(articleId, commentId, dto.toComment()));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/articles/{articleId}/comments/{commentId}")
    public void cancel(@PathVariable long articleId, @PathVariable long commentId){
        service.delete(articleId, commentId);
    }
}
