package com.ray.blog.controller.auth;

import com.ray.blog.dto.auth.AuthenticationRequest;
import com.ray.blog.dto.auth.AuthenticationResponse;
import com.ray.blog.dto.auth.RegisterRequest;
import com.ray.blog.service.auth.AuthenticationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/19/22:19
 * @Description:
 */
@RestController

@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService service;
  @PostMapping("/auth/register")
  public ResponseEntity<AuthenticationResponse> register(
          @RequestBody RegisterRequest request
  ){
    return ResponseEntity.ok(service.register(request));
  }

  @PostMapping("/auth/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
          @RequestBody AuthenticationRequest request
  ){
    return ResponseEntity.ok(service.authenticate(request));
  }

}
