package io.github.denrzv.moneytransferserviceapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoneyTransferServiceAppApplicationTests {

    private static final int PORT = 5500;
    @Autowired
    TestRestTemplate restTemplate;

    private static final GenericContainer<?> app = new GenericContainer<>("moneytransferserviceapp:latest")
            .withExposedPorts(PORT);

    @BeforeAll
    public static void setUp() {
        app.start();
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> devEntity = restTemplate.
                getForEntity("http://localhost:" + app.getMappedPort(PORT) + "/actuator/health", String.class);
        System.out.println(devEntity.getBody());

        Assertions.assertTrue(Objects.requireNonNull(devEntity.getBody()).contains("UP"));
    }

}
