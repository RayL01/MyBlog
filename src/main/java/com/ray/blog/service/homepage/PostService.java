package com.ray.blog.service.homepage;

import com.ray.blog.dto.homepage.PostCreateRequest;
import com.ray.blog.model.Post;
import com.ray.blog.repository.PostRepository;

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

  //todo: we should join 'media' & 'posts' as well as the 'comments' table and return the combined data
  public List<Post> getAllPosts() {
    // Fetch all posts
    List<Post> posts = postRepository.findAll();

    // Initialize media collections within the transactional context
    posts.forEach(
            post -> {
              Hibernate.initialize(post.getMedia());
            }
    );

    return posts;
  }

  public Post createPost(PostCreateRequest postCreateRequest) {
    return null;
  }
}
