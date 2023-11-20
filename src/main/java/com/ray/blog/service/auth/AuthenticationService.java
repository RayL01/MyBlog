package com.ray.blog.service.auth;

import com.ray.blog.config.JwtService;
import com.ray.blog.dto.auth.AuthenticationRequest;
import com.ray.blog.dto.auth.AuthenticationResponse;
import com.ray.blog.dto.auth.RegisterRequest;
import com.ray.blog.model.User;
import com.ray.blog.model.UserRole;
import com.ray.blog.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/19/22:22
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  public AuthenticationResponse register(RegisterRequest request) {
    var user =
            User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(UserRole.USER)

                    .build();
    repository.save(user);
    //By default set isrememberme to false
    var jwtToken = jwtService.generateToken(user, false);
    return AuthenticationResponse.builder().token(jwtToken).build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {

    //底层其实是调用authentication provider和UserDetailService来获取db中的用户密码进行校验
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            )
    );
    var user = repository.findByUsername(request.getUsername())
            .orElseThrow();

    var jwtToken = jwtService.generateToken(user, request.isRememberMe());
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
  }
}
