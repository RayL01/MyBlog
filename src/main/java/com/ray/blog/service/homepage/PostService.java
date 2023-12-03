package com.ray.blog.service.homepage;

import com.ray.blog.dto.homepage.PostCreateRequest;
import com.ray.blog.model.Post;
import com.ray.blog.model.User;
import com.ray.blog.repository.PostRepository;
import com.ray.blog.repository.UserRepository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/25/12:17
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;
  private final UserRepository userRepository;


  //TODO:
  // 1. We should convert posts to dto since there is some irrelevant fields not necessary for the response
  // 2. And also, post should be linked to comments, a user can have many comment, one post can have many comments
  // create Comment pojo, repository & convert post to dto in the end;
  public List<Post> getAllPosts() {
    // Fetch all posts
    List<Post> posts = postRepository.findAll();

    // Initialize media collections within the transactional context
    posts.forEach(
            post -> {
              Hibernate.initialize(post.getMedia());
              Hibernate.initialize(post.getUser());
            }
    );

    return posts;
  }
  public List<User> getAllUsers() {
    List<User> users = userRepository.findAll();

    // Initialize media collections within the transactional context
    users.forEach(
            user -> {
              Hibernate.initialize(user.getPost());

            }
    );

    return users;
  }

  public Post createPost(PostCreateRequest postCreateRequest) {
    return null;
  }


}
