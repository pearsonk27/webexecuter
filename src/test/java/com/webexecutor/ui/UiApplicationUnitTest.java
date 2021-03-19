package com.webexecutor.ui;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class UiApplicationUnitTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetHome() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("<!DOCTYPE html>\n<html>\n    <head lang=\"en\">\n        <meta charset=\"UTF-8\"/>\n        <title>ReactJS + Spring Data REST</title>\n        <link rel=\"stylesheet\" href=\"/main.css\" />\n    </head>\n    <body>\n\n        <div id=\"react\"></div>\n\n        <script src=\"built/bundle.js\"></script>\n\n    </body>\n</html>")));
    }
}
