package com.example.dashboard;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasSize;

@Testcontainers
public class IntegrationTest {
    @Container
    public static DockerComposeContainer<?> dockerComposeContainer =
            new DockerComposeContainer<>(new File("docker-compose.yml"))
                    .withExposedService("api", 8080);
    @Test
    public void shouldFindDashboards() {
        when().request("GET", "/dashboards")
                .then()
                .statusCode(200)
                        .body("", hasSize(1));

    }
}