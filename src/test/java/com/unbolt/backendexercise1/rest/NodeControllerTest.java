package com.unbolt.backendexercise1.rest;


import com.unbolt.backendexercise1.domain.Node;
import com.unbolt.backendexercise1.domain.NodeDesc;
import com.unbolt.backendexercise1.domain.NodeRoot;
import com.unbolt.backendexercise1.repository.NodeRepository;
import com.unbolt.backendexercise1.service.NodeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = NodeController.class)
@Import(NodeService.class)
public class NodeControllerTest {

    @MockBean
    NodeRepository repository;

    @Autowired
    private WebTestClient webClient;

    @Test
    void testAddNode() {
        NodeRoot nodeRoot = new NodeRoot();
        nodeRoot.setId("1");
        nodeRoot.setName("John");

        Mockito.when(repository.save(nodeRoot)).thenReturn(Mono.just(nodeRoot));

        webClient.post()
                .uri("/nodes")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(nodeRoot))
                .exchange()
                .expectStatus().isCreated();
        Mockito.verify(repository, Mockito.times(1)).save(nodeRoot);

    }

    @Test
    void testGetAllNodes() {
        NodeDesc nodeDesc = new NodeDesc();
        nodeDesc.setId("1");
        nodeDesc.setName("Glob");
        nodeDesc.setDescription("save reaction");

        List<Node> nodeList = new ArrayList<>();
        nodeList.add(nodeDesc);

        Flux<Node> nodeFlux = Flux.fromIterable(nodeList);

        Mockito
                .when(repository.findAll())
                .thenReturn(nodeFlux);

        webClient.get()
                .uri("/nodes")
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Node.class);

        Mockito.verify(repository, Mockito.times(1)).findAll();



    }



}
