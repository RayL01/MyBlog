package com.ray.blog.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/19/22:21
 * @Description:
 */
@Data // generate getters setters equals etc
@Builder //generate object by chaining methods
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
  private String token;
}
