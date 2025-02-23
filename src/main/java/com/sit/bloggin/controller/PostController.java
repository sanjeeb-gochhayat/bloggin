package com.sit.bloggin.controller;

import com.sit.bloggin.config.AppConfig;
import com.sit.bloggin.payloads.ApiResponse;
import com.sit.bloggin.payloads.PostDTO;
import com.sit.bloggin.payloads.PostResponse;
import com.sit.bloggin.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;
    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer userId, @PathVariable Integer categoryId){
        PostDTO createPost = this.postService.createPost(postDTO, userId, categoryId);
        return new ResponseEntity<PostDTO>(createPost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostByUser(@PathVariable Integer userId){
        List<PostDTO> posts = this.postService.getPostByUser(userId);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDTO> posts = this.postService.getPostByCategory(categoryId);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(@RequestParam(value = "pageNumber", defaultValue = AppConfig.PAGE_NUMBER, required = false) Integer pageNumber,
                                                   @RequestParam(value = "pageSize", defaultValue = AppConfig.PAGE_SIZE, required = false) Integer pageSize,
                                                   @RequestParam(value = "sortBy", defaultValue = AppConfig.SORT_BY, required = false) String sortBy
                                                    ){
        PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy);
        return ResponseEntity.ok(postResponse);
    }

    @GetMapping("/post/{postId}/posts")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId){
        PostDTO postDTO = this.postService.getPostById(postId);
        return ResponseEntity.ok(postDTO);
    }

    @DeleteMapping("/post/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ApiResponse("Post Deleted successfully", true);
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable Integer postId){
        PostDTO postDTO1 = this.postService.updatePost(postDTO, postId);
        return ResponseEntity.ok(postDTO1);
    }

    @GetMapping("/posts/search/{keyword}")
    public ResponseEntity<List<PostDTO>> searchPostByTitle(@PathVariable("keyword") String keyword){
        List<PostDTO> result = this.postService.searchPosts(keyword);
        return ResponseEntity.ok(result);
    }
}
