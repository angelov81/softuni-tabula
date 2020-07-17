package bg.softuni.tabula.stats;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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
