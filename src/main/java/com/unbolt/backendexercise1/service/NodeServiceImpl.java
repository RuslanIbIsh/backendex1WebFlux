package com.unbolt.backendexercise1.service;

import com.unbolt.backendexercise1.domain.Node;
import com.unbolt.backendexercise1.repository.NodeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {

    private NodeRepository nodeRepository;

    public NodeServiceImpl(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }


    @Override
    public Mono<Node> save(Node node) {
        return nodeRepository.save(node);
    }

    @Override
    public Flux<Node> findAll() {
        return nodeRepository.findAll();
    }
}
