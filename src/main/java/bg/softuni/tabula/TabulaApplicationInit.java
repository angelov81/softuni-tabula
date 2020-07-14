package bg.softuni.tabula;

import bg.softuni.tabula.announcement.model.AnnouncementEntity;
import bg.softuni.tabula.announcement.repository.AnnouncementRepository;
import bg.softuni.tabula.users.model.RoleEntity;
import bg.softuni.tabula.users.model.UserEntity;
import bg.softuni.tabula.users.repository.UserRepository;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TabulaApplicationInit implements CommandLineRunner {

  private final AnnouncementRepository announcementRepository;

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(String... args) throws Exception {
    if (announcementRepository.count() == 0) {
      AnnouncementEntity announcementEntity = new AnnouncementEntity();
      announcementEntity.setTitle("Hello, Softuni!");
      announcementEntity.setDescription("Welcome to the Srping advacned course!");
      announcementEntity.setCreatedOn(Instant.now());
      announcementEntity.setUpdatedOn(Instant.now());
      announcementRepository.save(announcementEntity);
    }

    if (userRepository.count() == 0) {
      // admin
      UserEntity admin = new UserEntity();
      admin.setEmail("admin@example.com");
      admin.setPasswordHash(passwordEncoder.encode("topsecret"));

      RoleEntity adminAdminRole = new RoleEntity();
      adminAdminRole.setRole("ROLE_ADMIN");

      RoleEntity adminUserRole = new RoleEntity();
      adminUserRole.setRole("ROLE_USER");

      admin.setRoles(List.of(adminAdminRole, adminUserRole));

      userRepository.save(admin);

      // user
      UserEntity user = new UserEntity();
      user.setEmail("user@example.com");
      user.setPasswordHash(passwordEncoder.encode("topsecret"));

      RoleEntity userUserRole = new RoleEntity();
      userUserRole.setRole("ROLE_USER");

      user.setRoles(List.of(userUserRole));

      userRepository.save(user);
    }
  }
}
