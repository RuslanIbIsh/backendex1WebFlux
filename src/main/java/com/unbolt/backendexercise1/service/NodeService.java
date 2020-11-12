package com.unbolt.backendexercise1.service;

import com.unbolt.backendexercise1.domain.Node;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface NodeService {

    Mono<Node> save(Node node);

    Flux<Node> findAll();
}
