package com.prodapt.learningspring.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Post {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  
  private String title;
  
  private String content;
  
  @CreationTimestamp
  private Date createdAt;

//  @UpdateTimestamp
  private Date updatedAt;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id", referencedColumnName = "id")
  private User author;
  
  public boolean isPresent() {

  		return createdAt != null;

  }
    
}