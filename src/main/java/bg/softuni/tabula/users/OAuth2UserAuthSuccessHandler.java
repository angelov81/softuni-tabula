package bg.softuni.tabula.users;

import bg.softuni.tabula.users.model.UserEntity;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class OAuth2UserAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

  private final UserService userService;

  public OAuth2UserAuthSuccessHandler(UserService userService) {
    this.userService = userService;

    setDefaultTargetUrl("/home");
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws ServletException, IOException {

    if (authentication instanceof OAuth2AuthenticationToken) {
      OAuth2AuthenticationToken oAuth2AuthenticationToken =
          (OAuth2AuthenticationToken)authentication;

      String email =
          oAuth2AuthenticationToken.
              getPrincipal().
              getAttribute("email");

      UserEntity userEntity = userService.getOrCreateUser(email);
    }
    super.onAuthenticationSuccess(request, response, authentication);
  }
}
