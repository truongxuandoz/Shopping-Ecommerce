package com.shoppingapp.DylanStore;

import com.shoppingapp.DylanStore.dto.UserDto;
import com.shoppingapp.DylanStore.entity.User;
import com.shoppingapp.DylanStore.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class DylanStoreApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TestEntityManager entityManager;

//	w
	@Test
	public void testFindUserByEmail_ExistingEmail() {
		// Create a user with a known email address in a setup method (not shown here)
		String email = "truong1411@gmail.com";
		Optional<User> user = userRepository.findByEmail(email);
		Assertions.assertThat(user).isPresent();
		Assertions.assertThat(user.get().getEmail()).isEqualTo(email);
	}
	@Test
	public void testFindUserByEmail(){
		String email = "nonexistent_user@example.com"; // Change to a non-existent email
		Optional<User> user = userRepository.findByEmail(email);
		Assertions.assertThat(user).isNull();
	}
}
