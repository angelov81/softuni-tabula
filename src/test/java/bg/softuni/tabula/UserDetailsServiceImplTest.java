package bg.softuni.tabula;


import static org.mockito.Mockito.when;

import bg.softuni.tabula.users.UserDetailsServiceImpl;
import bg.softuni.tabula.users.model.RoleEntity;
import bg.softuni.tabula.users.model.UserEntity;
import bg.softuni.tabula.users.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceImplTest {

  private UserDetailsServiceImpl serviceToTest;

  private String TEST_USER_NAME_EXISTS = "pesho@example.com";
  private String TEST_USER_NAME_NOT_EXISTS = "anna@example.com";

  private UserEntity testUserEntity;

  private RoleEntity testRoleEntity;

  @Mock
  private UserRepository mockUserRepository;

  @BeforeEach
  public void setUp() {
    testRoleEntity = new RoleEntity();
    testRoleEntity.setRole("ADMIN");

    testUserEntity = new UserEntity();
    testUserEntity.setEmail("pesho@example.com");
    testUserEntity.setPasswordHash("abcdef");
    testUserEntity.setRoles(List.of(testRoleEntity));

    serviceToTest = new UserDetailsServiceImpl(mockUserRepository);
  }

  @Test
  public void testUserNotFound() {

    when(mockUserRepository.findOneByEmail(TEST_USER_NAME_NOT_EXISTS)).
        thenReturn(Optional.empty());

    Assertions.assertThrows(UsernameNotFoundException.class, () -> {
      serviceToTest.loadUserByUsername(TEST_USER_NAME_NOT_EXISTS);
    });
  }

  @Test
  public void testUserFound() {

    when(mockUserRepository.findOneByEmail(TEST_USER_NAME_EXISTS)).
        thenReturn(Optional.of(testUserEntity));

    UserDetails actualDetails = serviceToTest.loadUserByUsername(TEST_USER_NAME_EXISTS);

    Assertions.assertEquals(testUserEntity.getEmail(), actualDetails.getUsername());
  }


}
