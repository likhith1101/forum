package com.prodapt.learningspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.learningspring.entity.Comment;
import com.prodapt.learningspring.entity.Post;

import jakarta.transaction.Transactional;

@Repository
public interface CommentCRUDRepository extends CrudRepository<Comment, Long>{
	List<Comment> findByPostId(long postId);
	void deleteByPostId(long id);
	
	@Modifying
	@Transactional
    @Query("UPDATE Comment c SET c.content = ?2 WHERE c.id = ?1")
    void updateContentById(long id, String content);

	List<Comment> findAllByPost(Post post);

}

