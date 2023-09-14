package com.prodapt.learningspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prodapt.learningspring.entity.Post;

import jakarta.transaction.Transactional;

public interface PostRepository extends CrudRepository<Post, Long>{
		List<Post> findByAuthorId(long userId);
//		void deleteById(Post post);
		
		@Transactional
	    @Modifying
	    @Query("UPDATE Post p SET p.content = ?3,p.title = ?2,p.updatedAt = CURRENT_TIMESTAMP  WHERE p.id = ?1")
	    void updatePost(long postId,String title,String content);
}	

