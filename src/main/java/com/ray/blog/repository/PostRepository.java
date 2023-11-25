package com.ray.blog.repository;

import com.ray.blog.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/25/12:06
 * @Description:
 */
public interface PostRepository extends JpaRepository<Post, Integer> {

}
