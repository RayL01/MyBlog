package com.ray.blog.service.homepage;

import com.ray.blog.dto.homepage.PostCreateRequest;
import com.ray.blog.dto.homepage.PostResponse;
import com.ray.blog.model.Post;
import com.ray.blog.model.User;
import com.ray.blog.repository.PostRepository;
import com.ray.blog.repository.UserRepository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


  // Fetch all posts in the homepage
  public List<PostResponse> getAllPosts() {
    // Fetch all posts
    List<Post> posts = postRepository.findAll();
    List<PostResponse> postResponses = new ArrayList<>();

    posts.forEach(
            post -> {
              Hibernate.initialize(post.getMedia());
              Hibernate.initialize(post.getUser());
              Hibernate.initialize(post.getComment());
              postResponses.add(
                      PostResponse.builder()
                              .id(post.getId())
                              .title(post.getTitle())
                              .content(post.getContent())
                              .createdAt(post.getCreatedAt())
                              .updatedAt(post.getUpdatedAt())
                              .authorId(post.getUser().getId())
                              .authorUsername(post.getUser().getUsername())
                              .authorEmail(post.getUser().getEmail())
                              .media(post.getMedia())
                              .comments(post.getComment())
                              .build()
              );
            }
    );
    return postResponses;
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
