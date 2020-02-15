package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	Contact findByUserName (String userName);
	Contact findByEmail (String Email);

}
