package com.sit.bloggin.services;

import com.sit.bloggin.payloads.PostDTO;

import java.util.List;

public interface PostService {
    //create
    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);
    //update
    PostDTO updatePost(PostDTO postDTO, Integer postId);
    //delete
    void deletePost(Integer postId);
    //getAllPost
    List<PostDTO> getAllPost();
    //get single post
    PostDTO getPostById(Integer postId);
    //get all post by category
    List<PostDTO> getPostByCategory(Integer categoryId);
    //get all post by user
    List<PostDTO> getPostByUser(Integer userId);
    //search
    List<PostDTO> searchPosts(String keyword);

}
