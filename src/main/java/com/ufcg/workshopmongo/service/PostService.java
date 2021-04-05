package com.ufcg.workshopmongo.service;

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
}
