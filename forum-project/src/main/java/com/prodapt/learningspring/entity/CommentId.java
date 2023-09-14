//package com.prodapt.learningspring.entity;
//
//import java.io.Serializable;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
//import lombok.Data;
//
//@Embeddable
//@Data
//public class CommentId implements Serializable{
//
//  private static final long serialVersionUID = 5469065220719817005L;
//  
//  @ManyToMany(cascade = CascadeType.ALL)
//  @JoinColumn(name = "user_id", referencedColumnName = "id")
//  private User user;
//  
//  @ManyToMany(cascade = CascadeType.ALL)
//  @JoinColumn(name = "post_id", referencedColumnName = "id")
//  private Post post;
//
//}