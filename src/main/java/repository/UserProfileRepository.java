package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
	
}
