package com.sit.bloggin.services;

import com.sit.bloggin.entities.Comment;
import com.sit.bloggin.payloads.CommentDTO;

public interface CommentService {
    CommentDTO createComment(CommentDTO commentDTO, Integer postId);
    void deleteComment(Integer commentId);
}
