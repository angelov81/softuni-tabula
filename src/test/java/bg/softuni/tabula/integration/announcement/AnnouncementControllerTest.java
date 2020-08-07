package bg.softuni.tabula.integration.announcement;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AnnouncementControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
  public void testNewAnnouncement() throws Exception {
    mockMvc.perform(
        post("/announcements/save").
        with(csrf()).
            contentType(MediaType.APPLICATION_FORM_URLENCODED).
            param("title", "hello, softuni!!!!!!!").
            param("description", "hello, softuni!!!!!!! hello, softuni!!!!!!! hello, softuni!!!!!!!"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/announcements"));
  }

  @Test
  @WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
  public void testNewAnnouncementFailed() throws Exception {
    mockMvc.perform(
        post("/announcements/save").
            with(csrf()).
            contentType(MediaType.APPLICATION_FORM_URLENCODED).
            param("title", "hello, softuni!!!!!!!").
            param("description", "short"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/announcements/new"));
  }

}
