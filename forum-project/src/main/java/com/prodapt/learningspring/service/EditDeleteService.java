package com.prodapt.learningspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodapt.learningspring.controller.binding.AddPostForm;
import com.prodapt.learningspring.entity.Comment;
import com.prodapt.learningspring.entity.Post;
import com.prodapt.learningspring.entity.User;
import com.prodapt.learningspring.repository.CommentCRUDRepository;
import com.prodapt.learningspring.repository.LikeCRUDRepository;
import com.prodapt.learningspring.repository.PostRepository;

import jakarta.transaction.Transactional;

@Service
public class EditDeleteService {
	
	@Autowired
    private PostRepository postRepository;
	
	@Autowired
	private LikeCRUDRepository likeCRUDRepository;
	
	@Autowired
	private CommentCRUDRepository commentCRUDRepository;
	
	public List<Post> getMyPosts(long userid) {
		return postRepository.findByAuthorId(userid);
	}
	
	public AddPostForm getSelectedPost(User author,long id) {
		AddPostForm postForm = new AddPostForm();
		postForm.setUserId(author.getId());
		Optional<Post> post;
		post = postRepository.findById(id);
		postForm.setUserId(post.get().getId());
		postForm.setTitle(post.get().getTitle());		
		postForm.setContent(post.get().getContent());
		return postForm;
	}
	
	public Post getPost(long id) {
		Optional<Post> post;
		post = postRepository.findById(id);
		return post.get();
	}
	
	@Transactional
	public void deletePostById(long id) {
//		postRepository.delete(postRepository.findById(id).get());
//		postRepository.delete(postRepository.findById(id).get());
		Post postToDelete = postRepository.findById(id).orElse(null);

        if (postToDelete != null) {
            // Remove the association between User and Post
            postToDelete.setAuthor(null);

            // Delete the Post
            postRepository.delete(postToDelete);
        }
	}
	
	@Transactional
	public void deleteLikesAndComments(long id) {
		likeCRUDRepository.deleteByPostId(id);
		commentCRUDRepository.deleteByPostId(id);
	}
	
	public void editPost(long id,String title,String content) {
		
		postRepository.updatePost(id,title,content);
	
	}
	
	public void deleteComment(long id) {
		
		commentCRUDRepository.deleteById(id);
	}
	
	public void updateComment(long id, String content) {
		
	commentCRUDRepository.updateContentById(id,content);
	
	}
	
	public Comment getSelectedComment(long id) {
		return commentCRUDRepository.findById(id).get();
	}
}
