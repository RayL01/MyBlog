package com.ray.blog.controller.homepage;

import com.ray.blog.model.Post;
import com.ray.blog.service.homepage.PostService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.NoArgsConstructor;
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
  public ResponseEntity<List<Post>> getAllPosts(){
    List<Post> posts =  postService.getAllPosts();
    if(posts.isEmpty()){
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(posts);
  }
}
