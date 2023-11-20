package com.ray.blog.repository;

import com.ray.blog.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import javax.swing.text.html.Option;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/19/21:51
 * @Description:
 */
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByUsername(String username);


}
