package com.prodapt.learningspring.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Embeddable
@Data
public class LikeCommentId implements Serializable{

  private static final long serialVersionUID = 5469065220719817005L;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "comment_id", referencedColumnName = "id")
  private Comment comment;

}
