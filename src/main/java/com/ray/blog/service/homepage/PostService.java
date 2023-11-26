package com.ray.blog.service.homepage;

import com.ray.blog.dto.homepage.PostCreateRequest;
import com.ray.blog.model.Post;
import com.ray.blog.repository.PostRepository;

import org.springframework.stereotype.Service;

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
    return postRepository.findAll();
  }

  public Post createPost(PostCreateRequest postCreateRequest) {
    return null;
  }
}
