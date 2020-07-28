package bg.softuni.tabula.integration.stats;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hibernate.boot.spi.InFlightMetadataCollector.EntityTableXref;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class StatsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @WithMockUser(username = "admin", roles={"USER", "ADMIN"})
  public void testStatsAccess() throws Exception {
    //todo - check the model attrib
    mockMvc.perform(get("/stats")).
        andExpect(status().isOk()).
        andExpect(view().name("stats/stats")).
        andExpect(model().attributeExists("requestCount", "startedOn"));
  }

  @Test
  @WithMockUser(username = "pesho", roles={"USER"})
  public void testStatsAccessDeniedForNormalUser() throws Exception {
    mockMvc.perform(get("/stats")).
        andExpect(status().isForbidden());
  }


}
