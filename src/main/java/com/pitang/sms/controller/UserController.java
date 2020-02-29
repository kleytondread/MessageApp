package com.pitang.sms.controller;

import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pitang.sms.dto.ContactDto;
import com.pitang.sms.dto.UserDto;
import com.pitang.sms.mapper.ModelMapperComponent;
import com.pitang.sms.model.Contact;
import com.pitang.sms.model.UserModel;
import com.pitang.sms.service.UserServiceInterface;;

@RestController
public class UserController {
	private UserServiceInterface userService;
	
	public UserController(UserServiceInterface userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<UserDto>> listUsers(){
		List<UserModel> users = userService.listUsers();
		
		if(users.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<UserDto> usersDto = ModelMapperComponent.modelMapper.map(users, new TypeToken<List<UserDto>>() {}.getType());
		
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(usersDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserDto> addUsers(@RequestBody UserDto userDto){
		
		if(userDto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.addUser(userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity <UserDto> findByUsername (@RequestBody String userName) {
		
		UserModel userModel = userService.findUserByUsername(userName);
		
		UserDto userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity <>(userDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity <UserDto> findByEmail (@RequestBody String email) {
		
		UserModel userModel = userService.findUserByUsername(email);
		
		UserDto userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity <>(userDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<UserDto> updateUsers(@PathVariable("id") Long id, @RequestBody UserDto userDto){
		
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.updateUser(userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}/profile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity <UserDto> addUserProfile (@RequestBody UserDto userDto){
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.addUserProfile(userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}/profile", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity <UserDto> updateUserProfile (@RequestBody UserDto userDto){
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.updateUserProfile(userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity <> (userDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}/contact", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity <ContactDto> addSingleContact (@RequestBody ContactDto contactDto, @RequestBody UserDto userDto){ //preciso de dois?
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		Contact contact = ModelMapperComponent.modelMapper.map(contactDto, new TypeToken<Contact>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.addSingleContact(contact, userModel);
		
		contactDto = ModelMapperComponent.modelMapper.map(contact, new TypeToken<ContactDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<> (contactDto, HttpStatus.OK); //existe alguma maneira de mandar o userDto tbm, ou não.	
	}
	
	@RequestMapping(value = "/user/{id}/contact", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity <ContactDto> updateContact (@RequestBody ContactDto contactDto){
		
		Contact contact = ModelMapperComponent.modelMapper.map(contactDto, new TypeToken<Contact>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.updateContact(contact);
		
		contactDto = ModelMapperComponent.modelMapper.map(contact, new TypeToken<ContactDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<> (contactDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<UserDto> deleteUser(@PathVariable("id") Long id){
		
		userService.deleteUser(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}