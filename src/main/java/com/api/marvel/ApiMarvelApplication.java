package com.api.marvel;

import com.api.marvel.persistence.entity.PermissionEntity;
import com.api.marvel.persistence.entity.RoleEntity;
import com.api.marvel.persistence.entity.RoleEnum;
import com.api.marvel.persistence.entity.UserEntity;
import com.api.marvel.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ApiMarvelApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiMarvelApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		/* CREATE PERMISSIONS */
		PermissionEntity readComic = PermissionEntity.builder()
				.permissionName("READ_COMIC")
				.build();

		PermissionEntity readCharacter = PermissionEntity.builder()
				.permissionName("READ_CHARACTER")
				.build();

		PermissionEntity createUser = PermissionEntity.builder()
				.permissionName("CREATE_USER")
				.build();

		PermissionEntity invalidUser = PermissionEntity.builder()
				.permissionName("INVALID_USER")
				.build();

		/* CREATE ROLES */
		RoleEntity admin = RoleEntity.builder()
				.roleName(RoleEnum.ADMIN)
				.permissions(Set.of(readComic, readCharacter, createUser, invalidUser))
				.build();

		RoleEntity user = RoleEntity.builder()
				.roleName(RoleEnum.USER)
				.permissions(Set.of(readCharacter, readComic))
				.build();

		/* CREATE USERS */
		UserEntity userJuan = UserEntity.builder()
				.username("juan")
				.password("$2a$10$62L03nSlCva8jgmVvl4qO.01Y9P2k.N4nohV9UPmXDqQyialGMKgW")
				.isEnabled(true)
				.accountNoLocked(true)
				.accountNoExpired(true)
				.credentialNoExpired(true)
				.roles(Set.of(admin))
				.build();

		UserEntity userSantiago = UserEntity.builder()
				.username("santiago")
				.password("$2a$10$62L03nSlCva8jgmVvl4qO.01Y9P2k.N4nohV9UPmXDqQyialGMKgW")
				.isEnabled(true)
				.accountNoLocked(true)
				.accountNoExpired(true)
				.credentialNoExpired(true)
				.roles(Set.of(user))
				.build();

		userRepository.saveAll(List.of(userSantiago, userJuan));
	}
}
