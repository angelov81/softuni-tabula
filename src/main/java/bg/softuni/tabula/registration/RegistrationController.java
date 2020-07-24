package bg.softuni.tabula.registration;

import bg.softuni.tabula.registration.model.RegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

  @GetMapping("/registration")
  public String showRegister(Model model) {
    model.addAttribute("formData", new RegistrationDTO());
    return "registration/registration";
  }

}
