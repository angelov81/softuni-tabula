package bg.softuni.tabula.registration;

import bg.softuni.tabula.registration.model.RegistrationDTO;
import bg.softuni.tabula.users.UserService;
import bg.softuni.tabula.users.model.UserEntity;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class RegistrationController {

  private UserService userService;

  @GetMapping("/registration")
  public String showRegister(Model model) {
    model.addAttribute("formData", new RegistrationDTO());
    return "registration/registration";
  }

  @PostMapping("/registration")
  public String register(@Valid @ModelAttribute("formData") RegistrationDTO registrationDTO,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "registration/registration";
    }

    if (userService.existsUser(registrationDTO.getEmail())) {
      bindingResult.rejectValue("email",
          "error.email",
          "An account with this email already exists.");
      return "registration/registration";
    }

    userService.createAndLoginUser(registrationDTO.getEmail(), registrationDTO.getPassword());

    return "redirect:/home";
  }

}
