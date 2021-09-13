package ardi.springintro.controller;

import ardi.springintro.SpringIntroApplication;
import ardi.springintro.model.People;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
                classes = SpringIntroApplication.class)
@AutoConfigureWebTestClient
class PeopleControllerTest {

    @Autowired
    WebTestClient client;

    static MockWebServer mockWebServer;

    @BeforeAll
    static void beforeAll() throws Exception{
        mockWebServer = new MockWebServer();
        mockWebServer.start(10001);
        mockWebServer.setDispatcher(new Dispatcher() {

            @Override
            public MockResponse dispatch(RecordedRequest recordedRequest) throws InterruptedException {
                MockResponse mockResponse = new MockResponse();
                mockResponse.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                mockResponse.setResponseCode(200);

                String filePath = "src/test/resources/jsonResponse/";
                if (recordedRequest.getPath().equals("/people")) {
                    filePath += "src/test/resources/jsonResponse/PeopleResponse.json";
                }
                else if (recordedRequest.getPath().equals("/people/1")) {
                    filePath = "src/test/resources/jsonResponse/People1Response.json";
                }

                try {
                    FileInputStream fileInputStream = new FileInputStream(filePath);
                    String content = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8.name());
                    mockResponse.setBody(content);
                } catch (Exception e) {
                    System.out.println("ERROR" + e.getMessage());
                }
                return mockResponse;
            }
        });
    }

    @AfterAll
    public static void afterAll() throws Exception {
        mockWebServer.shutdown();
    }

    @Test
    void getPeopleTest() {
        List<People> response = client.get()
                .uri("/people")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<List<People>>() {})
                .returnResult()
                .getResponseBody();

        assertNotNull(response);
        assertTrue(response.size() == 2);
        assertEquals("male", response.get(0).getGender());
        assertEquals("C-3PO", response.get(1).getName());
        assertEquals("96", response.get(2).getHeight());
    }

    @Test
    void getPeopleByIdTest() {
        People response = client.get()
                .uri("/people/1")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<People>() {})
                .returnResult()
                .getResponseBody();

        assertNotNull(response);
        assertEquals("Luke Skywalker", response.getName());
        assertEquals("male", response.getGender());
        assertEquals("172", response.getHeight());
    }
}
