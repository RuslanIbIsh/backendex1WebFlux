package com.unbolt.backendexercise1.rest;

import com.unbolt.backendexercise1.domain.Node;
import com.unbolt.backendexercise1.service.NodeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/nodes")
public class NodeController {

    private NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Mono<Node> addNode(@RequestBody Node node) {
        return nodeService.save(node);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Flux<Node> getAllNodes() {
        return nodeService.findAll();
    }

}
