package hr.tvz.zaninovic.hardwareapp.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
class ReviewControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private final String tokenAdmin =
      "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY1NDYwODMwOSwiaWF0IjoxNjU0MDAzNTA5LCJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4ifQ.Mb-GxODv7FepzM8HYO3y_15iVxe7Rof_V7UVUOUfuL6x7UspPhLs-7R1zOpRA24Ul0k5bm3QxkSgqbbciSozzg";

  @Test
  void getAllReviews_roleAdmin() throws Exception {
    this.mockMvc.perform(
            get("/review")
                .with(user("admin").password("admin").roles("ADMIN"))
                .with(csrf())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenAdmin))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
  }

  @Test
  void getAllReviews_roleUser() throws Exception {
    String tokenUser = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjU0NjA4NDM2LCJpYXQiOjE2NTQwMDM2MzYsImF1dGhvcml0aWVzIjoiUk9MRV9VU0VSIn0.hbHvanx7nLuy6UNNaIIccRTaw66d0pVJa6z3_j92qRbeC1J07ctoYDfx9xcK9c4YR6cuURoj8ZxI_md42k9XAg";
    this.mockMvc.perform(
            get("/review")
                .with(user("user").password("user").roles("USER"))
                .with(csrf())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenUser))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
  }

  @Test
  void getAllHardwareByCode() throws Exception {
    this.mockMvc.perform(
            get("/review?code=1")
                .with(user("admin").password("admin").roles("ADMIN"))
                .with(csrf())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenAdmin))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
  }
}
