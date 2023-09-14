package com.prodapt.learningspring.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class LikeRecord {
  
  @Column(unique=true)
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at")
  private Date createdAt;
  
  @EmbeddedId
  private LikeId likeId;
  
}
