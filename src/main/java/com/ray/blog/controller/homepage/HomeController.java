package com.ray.blog.controller.homepage;

import com.ray.blog.dto.homepage.PostCreateRequest;
import com.ray.blog.dto.homepage.PostResponse;
import com.ray.blog.model.Post;
import com.ray.blog.model.User;
import com.ray.blog.service.homepage.PostService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/25/12:10
 * @Description:
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/homepage")
public class HomeController {
  private final PostService postService;


  @GetMapping("/posts")
  public ResponseEntity<List<PostResponse>> getAllPosts(){
    List<PostResponse> postResponses = postService.getAllPosts();
    if(postResponses.isEmpty()){
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(postResponses);
  }
  @GetMapping("/users")
  public ResponseEntity<List<User>> getAllUsers(){
    List<User> users =  postService.getAllUsers();
    if(users.isEmpty()){
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(users);
  }
  @PostMapping("/posts")
  public ResponseEntity<Post> createPost(@RequestBody PostCreateRequest postCreateRequest){
    Post post = postService.createPost(postCreateRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(post);
  }
}
