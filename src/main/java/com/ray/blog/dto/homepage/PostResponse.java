package com.ray.blog.dto.homepage;

import com.ray.blog.model.Comment;
import com.ray.blog.model.Media;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/12/03/13:27
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// return posts, fields are as follows:
/**
 * 1. post id
 * 2. post title
 * 3. post content
 * 4. post created time
 * 5. post updated time
 * 6. post author id
 * 7. post author username
 * 8. post author email
 * 9. list of post media
 * 10. list of post comments
 *
 */
public class PostResponse {
  private Integer id;
  private String title;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Integer authorId;
  private String authorUsername;
  private String authorEmail;
  private List<Media> media;
  private List<Comment> comments;

}
