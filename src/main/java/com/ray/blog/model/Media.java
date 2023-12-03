package com.ray.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/26/01:44
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "media")
public class Media {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;



  @Column(name = "media_url",nullable = false, length = 255)
  private String mediaUrl;

  @Enumerated(EnumType.STRING)
  @Column(name = "media_type",nullable = false)
  private MediaType mediaType;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "post_id", referencedColumnName = "id")
  @JsonIgnore
  private Post post;
}
