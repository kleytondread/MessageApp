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
import com.pitang.sms.dto.UserProfileDto;
import com.pitang.sms.mapper.ModelMapperComponent;
import com.pitang.sms.model.Contact;
import com.pitang.sms.model.UserModel;
import com.pitang.sms.model.UserProfile;
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
	public ResponseEntity<List<UserDto>> listUsers(){ //ok!
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
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){ //ok!
		
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
	
	@RequestMapping(value = "/user/findUserName/{userName}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity <UserDto> findByUsername (@PathVariable String userName) { //ok!
		
		if(""==userName || null == userName) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		UserModel userModel = userService.findUserByUsername(userName);
		
		UserDto userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity <>(userDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/findUserEmail/{email}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity <UserDto> findByEmail (@PathVariable String email) { //ok!
		
		if(""==email || null == email) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		UserModel userModel = userService.findUserByEmail(email);
		
		UserDto userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity <>(userDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<UserDto> updateUsers(@PathVariable("id") Long id, @RequestBody UserDto userDto){ //ok!
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		userDto.setUserId(id);
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();

		userService.updateUser(userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}/profile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity <UserProfileDto> addUserProfile (@PathVariable("id") Long id, @RequestBody UserProfileDto userProfileDto){
		
		if(userProfileDto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		UserModel userModel = userService.findUserById(id);
		
		UserProfile userProfile = ModelMapperComponent.modelMapper.map(userProfileDto, new TypeToken<UserProfile>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userModel.setUserProfile(userProfile);
		//UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		//ModelMapperComponent.modelMapper.validate();
		
		userService.addUserProfile(userModel);
		
		userProfileDto = ModelMapperComponent.modelMapper.map(userProfile, new TypeToken<UserProfileDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<>(userProfileDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}/profile", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity <UserDto> updateUserProfile (@RequestBody UserDto userDto){
		
		if(userDto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		UserModel userModel = ModelMapperComponent.modelMapper.map(userDto, new TypeToken<UserModel>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.updateUserProfile(userModel);
		
		userDto = ModelMapperComponent.modelMapper.map(userModel, new TypeToken<UserDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity <> (userDto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}/contact", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity <ContactDto> addContact (@PathVariable("id") Long id, @RequestBody ContactDto contactDto){ //preciso de dois?
		
		if(id == null || contactDto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Contact contact = ModelMapperComponent.modelMapper.map(contactDto, new TypeToken<Contact>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		userService.addContact(contact, id);
		
		contactDto = ModelMapperComponent.modelMapper.map(contact, new TypeToken<ContactDto>() {}.getType());
		ModelMapperComponent.modelMapper.validate();
		
		return new ResponseEntity<> (contactDto, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/user/{id}/contact", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity <ContactDto> updateContact (@RequestBody ContactDto contactDto){
		
		if(contactDto == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
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