package com.example.crudenv.controller;

import com.example.crudenv.dto.CommentDto;
import com.example.crudenv.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/regis")
    public ResponseEntity<CommentDto> commentRegister(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(commentService.commentRegister(commentDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<CommentDto>> getComments() {
        return ResponseEntity.ok(commentService.getComments());
    }

    // 특정 댓글 조회 (id로)
    @GetMapping("/get/{comment_id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable("comment_id") Long id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }
}
