package com.prodapt.learningspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class LikeCommentRecord {
  
  // @Column(unique=true)
  // @GeneratedValue(strategy=GenerationType.IDENTITY)
  // //private int id;
  
  @EmbeddedId
  private LikeCommentId likeCommentId;

}


