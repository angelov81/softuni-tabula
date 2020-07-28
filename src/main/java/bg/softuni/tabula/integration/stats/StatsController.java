package bg.softuni.tabula.integration.stats;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class StatsController {

  private StatsService statsService;

  public StatsController(StatsService statsService) {
    this.statsService = statsService;
  }

  @GetMapping("/stats")
  public String stats(Model model) {

    model.addAttribute("requestCount", statsService.getRequestCount());
    model.addAttribute("startedOn", statsService.getStartedOn());

    return "stats/stats";
  }

}
