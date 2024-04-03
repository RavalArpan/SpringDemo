package com.example.springdemo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;
    private int numberToBeDoubled = 7;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void doubleControllerShouldReturnTen() throws Exception{
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/double?number="+numberToBeDoubled, String.class)).contains("14");
    }

}
