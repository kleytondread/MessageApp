package repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import model.Message;
import model.UserModel;

public interface MessageRepository extends JpaRepository <Message, Long> {
	ArrayList<Message> findBySenderRecipient (UserModel sender, UserModel recipient);

}
