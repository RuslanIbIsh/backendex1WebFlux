package com.unbolt.backendexercise1.repository;

import com.unbolt.backendexercise1.domain.Node;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends ReactiveMongoRepository<Node, String> {
}
