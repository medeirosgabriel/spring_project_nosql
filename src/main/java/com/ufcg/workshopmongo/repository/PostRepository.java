package com.ufcg.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ufcg.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {}
