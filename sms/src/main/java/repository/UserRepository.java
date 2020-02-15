package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	
	UserModel findByUserName(String userName);
	UserModel findByEmail(String email);
	
}
