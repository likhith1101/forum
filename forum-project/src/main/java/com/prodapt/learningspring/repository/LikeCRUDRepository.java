package com.prodapt.learningspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prodapt.learningspring.entity.LikeId;
import com.prodapt.learningspring.entity.LikeRecord;
import com.prodapt.learningspring.entity.Post;
import com.prodapt.learningspring.entity.User;

public interface LikeCRUDRepository extends CrudRepository<LikeRecord, LikeId> {
	public Integer countByLikeIdPost(Post post);

	@Modifying
	@Query(value = "DELETE FROM like_record WHERE post_id = ?1", nativeQuery = true)
	void deleteByPostId(Long postId);
//	  void deleteByPostId(long id);

	public LikeRecord findByLikeIdUserAndLikeIdPost(User user, Post post);

	boolean existsByLikeIdUserAndLikeIdPost(Optional<User> user, Optional<Post> post);
}
