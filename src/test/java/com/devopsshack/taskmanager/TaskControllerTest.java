package com.devopsshack.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateAndListTask() throws Exception {
        String payload = "{\"title\":\"Ecrire le pipeline\",\"done\":false}";

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Ecrire le pipeline"));

        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Ecrire le pipeline"));
    }

    @Test
    void shouldReturn404WhenTaskNotFound() throws Exception {
        mockMvc.perform(get("/api/tasks/999"))
                .andExpect(status().isNotFound());
    }
    @Test
    void shouldUpdateTask() throws Exception {

    String createPayload =
            "{\"title\":\"Ancienne valeur\",\"done\":false}";

    mockMvc.perform(post("/api/tasks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(createPayload))
            .andExpect(status().isCreated());

    String updatePayload =
            "{\"title\":\"Nouvelle valeur\",\"done\":true}";

    mockMvc.perform(put("/api/tasks/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(updatePayload))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title")
                    .value("Nouvelle valeur"))
            .andExpect(jsonPath("$.done")
                    .value(true));
}
}
