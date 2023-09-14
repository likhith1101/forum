package com.prodapt.learningspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.prodapt.learningspring.entity.Comment;
import com.prodapt.learningspring.entity.LikeCommentId;
import com.prodapt.learningspring.entity.LikeCommentRecord;
import com.prodapt.learningspring.entity.User;

public interface CommentLikeCRUDRepository extends CrudRepository<LikeCommentRecord,LikeCommentId>{
    public Integer countByLikeCommentIdComment(Comment comment);
    boolean existsByLikeCommentIdUserAndLikeCommentIdComment(User user, Comment comment);
    // public User findLikedUserByComment(Comment comment);
}
