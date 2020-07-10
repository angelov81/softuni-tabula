package bg.softuni.tabula.announcement.web;

import bg.softuni.tabula.announcement.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/announcements")
public class AnnouncementController {

  private final AnnouncementService announcementService;

  //TODO: Role user
  @GetMapping
  public String announcement(Model model) {

    model.addAttribute("announcements",
        announcementService.findAll());

    return "announcement/announcements";
  }
}
