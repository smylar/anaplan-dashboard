package com.example.dashboard;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import com.example.dashboard.service.DashboardService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = DashboardApplication.class)
@TestPropertySource("classpath:application-test.properties")
class ControllerTests {
    @MockBean
    private DashboardService mockService;

    @Test
    void testErrorResponse() {
        when(mockService.getDashboards()).thenThrow(new RuntimeException("test"));
        RestAssured.when().request("GET", "/dashboards")
                .then()
                .statusCode(500)
                .body("message", equalTo("Something terrible has happened"));
    }
}