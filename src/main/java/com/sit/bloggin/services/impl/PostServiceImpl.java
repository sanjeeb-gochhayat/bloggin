package com.sit.bloggin.services.impl;

import com.sit.bloggin.entities.Category;
import com.sit.bloggin.entities.Post;
import com.sit.bloggin.entities.User;
import com.sit.bloggin.exception.ResourceNotFoundException;
import com.sit.bloggin.payloads.PostDTO;
import com.sit.bloggin.repositories.CategoryRepo;
import com.sit.bloggin.repositories.PostRepo;
import com.sit.bloggin.repositories.UserRepo;
import com.sit.bloggin.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", categoryId));
       Post post = this.modelMapper.map(postDTO, Post.class);
       post.setImageName("default.png");
       post.setAddedDate(new Date());
       post.setUser(user);
       post.setCategory(category);

      Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", postId));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDTO.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", postId));
        this.postRepo.delete(post);
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> posts= this.postRepo.findAll();
        return posts.stream().map((post)-> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());

    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "PostId", postId));
        return this.modelMapper.map(post, PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        List<Post> byCategory = this.postRepo.findByCategory(cat);
        List<PostDTO> byCategoryDtos = byCategory.stream().map((post)-> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return byCategoryDtos;
    }

    @Override
    public List<PostDTO> getPostByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
        List<Post> byUser = this.postRepo.findByUser(user);
        List<PostDTO> byUserDtos = byUser.stream().map((post)-> this.modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());
        return byUserDtos;
    }

    @Override
    public List<PostDTO> searchPosts(String keyword) {
        return List.of();
    }
}
