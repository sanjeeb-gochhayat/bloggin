package com.sit.bloggin.services.impl;

import com.sit.bloggin.entities.Comment;
import com.sit.bloggin.entities.Post;
import com.sit.bloggin.exception.ResourceNotFoundException;
import com.sit.bloggin.payloads.CommentDTO;
import com.sit.bloggin.repositories.CommentRepo;
import com.sit.bloggin.repositories.PostRepo;
import com.sit.bloggin.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", postId));
        Comment comment = this.modelMapper.map(commentDTO, Comment.class);
        comment.setPost(post);
        Comment save = this.commentRepo.save(comment);
        return this.modelMapper.map(save, CommentDTO.class);

    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
        this.commentRepo.delete(comment);
    }
}
