package com.github.bolkunets.alexandr.helloworld

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
@AutoConfigureWebTestClient
class HelloWorldApplicationTests {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun justHello() {
        webTestClient.get()
                .uri("/")
                .exchange()
                .expectBody()
                .jsonPath("$.message").isEqualTo("hello world!!!")
    }

    @Test
    fun helloName() {
        webTestClient.get()
                .uri {
                    it.queryParam("name", "sanya").build()
                }
                .exchange()
                .expectBody()
                .jsonPath("$.message").isEqualTo("hello world, sanya!!!")
    }

}
