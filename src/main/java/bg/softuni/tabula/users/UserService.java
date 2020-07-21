package bg.softuni.tabula.users;

import bg.softuni.tabula.users.model.RoleEntity;
import bg.softuni.tabula.users.model.UserEntity;
import bg.softuni.tabula.users.repository.UserRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  public UserEntity getOrCreateUser(String email) {

    Objects.requireNonNull(email);

    Optional<UserEntity> userEntityOpt =
        userRepository.findOneByEmail(email);

    return userEntityOpt.
        orElseGet(() -> createUser(email));
  }

  private UserEntity createUser(String email) {
    LOGGER.info("Creating a new user with email [GDPR].");
    UserEntity userEntity = new UserEntity();
    userEntity.setEmail(email);

    RoleEntity userRole = new RoleEntity();
    userRole.setRole("ROLE_USER");

    userEntity.setRoles(List.of(userRole));

    return userRepository.save(userEntity);
  }

}
