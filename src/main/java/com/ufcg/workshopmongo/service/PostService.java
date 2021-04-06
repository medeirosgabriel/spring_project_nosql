package com.ufcg.workshopmongo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.workshopmongo.domain.Post;
import com.ufcg.workshopmongo.repository.PostRepository;
import com.ufcg.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) { 
		Optional<Post> post = postRepository.findById(id);
		if (!post.isPresent()) {
			throw new ObjectNotFoundException("Object Not Found");
		}
		return post.get();
	}
	
	public List<Post> findByTitle(String text) {
		return this.postRepository.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		return this.postRepository.findByTitleContainingIgnoreCase(text);
	}
}
