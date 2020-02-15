package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import exceptions.ExceptionBadRequest;
import exceptions.ExceptionConflict;
import model.UserModel;
import model.UserProfile;
import repository.UserProfileRepository;
import repository.UserRepository;


@Service
public class UserServiceImpl implements UserServiceInterface{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Override
	public List<UserModel> listUsers() {
		if(userRepository.findAll().size() == 0) {
			return null;
		}
		return userRepository.findAll();
	}
	
	@Override
	public UserModel findUserByUsername(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public UserModel addUser(UserModel user) {
		validateUser(user);
		checkIntegrity(user);
		return userRepository.save(user);
	}
	
	@Override
	public UserModel updateUser(UserModel user) {
		if(user.getUserId() == null) {
			throw new ExceptionBadRequest("Necessário informar o id para atualizar!");
		}
		checkIntegrity(user);
		//validateUser(user);
		return userRepository.save(user);
	}
	
	private void checkIntegrity(UserModel user) {
		checkMandatoryFields(user);
		checkRelations(user);
	}
	private void checkMandatoryFields(UserModel user) {
		if(user == null) {
			throw new ExceptionBadRequest("Usuário não pode ser nulo!");
		}
		if(StringUtils.isEmpty(user.getEmail())) {
			throw new ExceptionBadRequest("Necessário informar o Email do usuário.");
		}
		if(StringUtils.isEmpty(user.getFirstName())) {
			throw new ExceptionBadRequest("Necessário informar o Primeiro Nome do usuário.");
		}
		if(StringUtils.isEmpty(user.getPassword())) {
			throw new ExceptionBadRequest("Necessário informar a Senha do usuário.");
		}
		if(StringUtils.isEmpty(user.getUserName())) {
			throw new ExceptionBadRequest("Necessário informar o Nome do usuário.");
		}
	}
	
	private void validateUser(UserModel user) {
		if(!StringUtils.isEmpty(user.getUserName()) && userRepository.findByUserName(user.getUserName()) != null) {
			throw new ExceptionConflict("Nome de usuário informado já existe!");
		}
		if(!StringUtils.isEmpty(user.getEmail()) && userRepository.findByEmail(user.getEmail()) != null) {
			throw new ExceptionConflict("Email informado já existe!");
		}
	}
	
	private void checkRelations(UserModel user) {
		if(user.getUserProfile() != null && user.getUserProfile().getId() != null &&
				userProfileRepository.findById(user.getUserProfile().getId()) == null) {
			throw new ExceptionBadRequest("Perfil do usuário não encontrado.");
		}else if(user.getUserProfile() != null && user.getUserProfile().getId() == null) {
			user.setUserProfile(null);
		}
	}

	@Override
	public void deleteUser(Long id) {
		Optional<UserModel> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.deleteById(id);
		}
	}

}