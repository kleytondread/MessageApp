package com.pitang.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pitang.sms.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {	
	
}
