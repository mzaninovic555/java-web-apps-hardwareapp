package hr.tvz.zaninovic.hardwareapp.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.zaninovic.hardwareapp.command.HardwareCommand;
import hr.tvz.zaninovic.hardwareapp.domain.HardwareType;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
class HardwareControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;

  private final String tokenAdmin = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY1NDYwODMwOSwiaWF0IjoxNjU0MDAzNTA5LCJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4ifQ.Mb-GxODv7FepzM8HYO3y_15iVxe7Rof_V7UVUOUfuL6x7UspPhLs-7R1zOpRA24Ul0k5bm3QxkSgqbbciSozzg";
  private final String tokenUser = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjU0NjA4NDM2LCJpYXQiOjE2NTQwMDM2MzYsImF1dGhvcml0aWVzIjoiUk9MRV9VU0VSIn0.hbHvanx7nLuy6UNNaIIccRTaw66d0pVJa6z3_j92qRbeC1J07ctoYDfx9xcK9c4YR6cuURoj8ZxI_md42k9XAg";

  HardwareCommand testHardware =
      new HardwareCommand("test", "1", 1.99, HardwareType.CPU, 55);

  @Test
  void getAllHardware_roleAdmin() throws Exception {
    this.mockMvc.perform(
      get("/hardware")
          .with(user("admin").password("admin").roles("ADMIN"))
          .with(csrf())
          .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenAdmin))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
  }

  @Test
  void getAllHardware_roleUser() throws Exception {
    this.mockMvc.perform(
            get("/hardware")
                .with(user("user").password("user").roles("USER"))
                .with(csrf())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenUser))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
  }

  @Test
  void getHardwareByCode() throws Exception {
    this.mockMvc.perform(
            get("/hardware/1")
                .with(user("user").password("user").roles("USER"))
                .with(csrf())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenUser))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
  }

  @Test
  @Transactional
  void save_roleAdmin() throws Exception {
    this.mockMvc.perform(
        post("/hardware")
            .with(user("admin").password("admin").roles("ADMIN"))
            .with(csrf())
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenAdmin)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(testHardware))
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.name").value("test"))
        .andExpect(jsonPath("$.code").value("5"))
        .andExpect(jsonPath("$.price").value(1.99));
  }

  @Test
  @Transactional
  void save_roleUser() throws Exception {
    this.mockMvc.perform(
            post("/hardware")
                .with(user("user").password("user").roles("USER"))
                .with(csrf())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenUser)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testHardware))
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isForbidden());
  }

  @Test
  @Transactional
  void update_roleAdmin() throws Exception {
    this.mockMvc.perform(
        put("/hardware/1")
            .with(user("admin").password("admin").roles("ADMIN"))
            .with(csrf())
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenAdmin)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(testHardware))
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  @Transactional
  void update_roleUser() throws Exception {
    this.mockMvc.perform(
            put("/hardware/1")
                .with(user("user").password("user").roles("USER"))
                .with(csrf())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenUser)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testHardware))
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isForbidden());
  }

  @Test
  @Transactional
  void delete_roleAdmin() throws Exception {
    this.mockMvc.perform(
        delete("/hardware/1")
            .with(user("admin").password("admin").roles("ADMIN"))
            .with(csrf())
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenAdmin)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
  }

  @Test
  @Transactional
  void delete_roleUser() throws Exception {
    this.mockMvc.perform(
            delete("/hardware/1")
                .with(user("user").password("user").roles("USER"))
                .with(csrf())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenUser)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isForbidden());
  }
}