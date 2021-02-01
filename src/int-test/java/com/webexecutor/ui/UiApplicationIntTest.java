package com.webexecutor.ui;

import static org.assertj.core.api.Assertions.*;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UiApplicationIntTest {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void testGetHome() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody()).isEqualTo("<!DOCTYPE html>\n" + 
        "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:sec=\"https://www.thymeleaf.org/thymeleaf-extras-springsecurity3\">\n" +
        "    <head>\n        <title>Webexecuter</title>\n    </head>\n    <body>\n        <h1>Welcome!</h1>\n" +
        "        <br />\n        <p>Click <a href=\"/dashboard\">here</a> to go to the dashboard</p>\n    </body>\n</html>");
    }
}
