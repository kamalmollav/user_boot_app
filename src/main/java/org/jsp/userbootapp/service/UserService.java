package org.jsp.userbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.userbootapp.dao.UserDao;
import org.jsp.userbootapp.dto.ResponseStructure;
import org.jsp.userbootapp.dto.User;
import org.jsp.userbootapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
private UserDao dao;

public  ResponseEntity<ResponseStructure<User>> saveUser(User user){
	ResponseStructure<User> structure=new ResponseStructure<User>();
	structure.setMessage("user verified successfully");
	structure.setBody(dao.saveUser(user));
	structure.setCode(HttpStatus.CREATED.value());
	return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
}
public  ResponseEntity<ResponseStructure<User>>updateUser(User user){
	ResponseStructure<User> structure=new ResponseStructure<User>();
	structure.setMessage("user updated successfully");
	structure.setBody(dao.updateUser(user));
	structure.setCode(HttpStatus.ACCEPTED.value());
	return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
}
public  ResponseEntity<ResponseStructure<User>> findUser(int id){
	ResponseStructure<User> structure=new ResponseStructure<User>();
	Optional<User> recUser=dao.findUser(id);
	if(recUser.isPresent()) {
	structure.setBody(recUser.get());
	structure.setMessage("User found");
	structure.setCode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
}
	throw new IdNotFoundException();
}
public  ResponseEntity<ResponseStructure<List<User>>> findAll(){
	ResponseStructure<List<User>> structure=new ResponseStructure<>();
	structure.setBody(dao.findAlL());
	structure.setMessage("all users are displayed");
	structure.setCode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
}
public  ResponseEntity<ResponseStructure<String>> deleteUser(int id){
	ResponseStructure<String> structure=new ResponseStructure<String>();
	Optional<User> recUser=dao.findUser(id);
	if(recUser.isPresent()) {
		dao.deleteUser(id);
	structure.setMessage("user found");
	structure.setBody("user deleted");
	structure.setCode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
}
	throw new IdNotFoundException();
}
public  ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password){
	ResponseStructure<User> structure=new ResponseStructure<>();
	Optional<User> recUser=dao.VerifyUser(phone,password);
	if(recUser.isPresent()) {
		structure.setBody(recUser.get());
	structure.setMessage("User verified successfully");
	structure.setCode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
}
	throw new IdNotFoundException();
}
public  ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password){
	ResponseStructure<User> structure=new ResponseStructure<>();
	Optional<User> recUser=dao.VerifyUser(email,password);
	if(recUser.isPresent()) {
		structure.setBody(recUser.get());
	structure.setMessage("user verified successfully");
	structure.setCode(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
}
	throw new IdNotFoundException();
}
}



