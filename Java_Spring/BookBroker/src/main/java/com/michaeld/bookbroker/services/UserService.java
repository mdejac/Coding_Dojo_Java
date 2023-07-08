package com.michaeld.bookbroker.services;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.michaeld.bookbroker.models.User;
import com.michaeld.bookbroker.repositories.UserRepo;
import com.michaeld.bookbroker.validators.LoginUser;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public User create(User u) {
		return userRepo.save(u);
	}
	
	public User register(User newUser, BindingResult result) {
		if (!userRepo.findByEmail(newUser.getEmail()).isEmpty()) {
			result.rejectValue("email", "Email", "Email already Registered.");
		}
		
		if (!userRepo.findByUserName(newUser.getUserName()).isEmpty()) {
			result.rejectValue("userName", "Matches", "Sorry, this user name is already in use.");
		}
		
		if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
		    result.rejectValue("password", "Matches", "The Password must match Confirm Password!");
		    result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password!");
		}
		
		if (!ageVerify(newUser.getDateOfBirth())) {
			result.rejectValue("dateOfBirth", "Fail", "Sorry you are too young to register.");
		}
		
		if (!newUser.getPassword().matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[a-z]).{8,}$")) {
			result.rejectValue("password", "Requirement", "Password must contain at least one capital letter, one digit, and one symbol.");
			result.rejectValue("confirmPassword", "Requirement", "Password must contain at least one capital letter, one digit, and one symbol.");
		}
		
		if (result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		User user = userRepo.findByEmail(newLogin.getEmail()).orElse(null);
		if (user == null) {
			if (!newLogin.getEmail().equals("")) {
				result.rejectValue("email", "Email", "Email not registered.");				
			}
		} else if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			if (!newLogin.getPassword().equals("")) {
				result.rejectValue("password", "Invalid", "Invalid credentials!");
				result.rejectValue("email", "Invalid", "Invalid credentials!");
			}
		}
		
		if (result.hasErrors()) {
			return null;
		}
		return user;
	}
	
	private boolean ageVerify(Date dateOfBirth) {
	    Calendar calendar = GregorianCalendar.getInstance();
	    calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18);
		return calendar.getTime().after(dateOfBirth);
	}
	
	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	public User getById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public User getByEmail(String email) {
		return userRepo.findByEmail(email).orElse(null);
	}
	
	public User getByUserName(String userName) {
		return userRepo.findByUserName(userName).orElse(null);
	}
	
	public User update(User u) {
		return userRepo.save(u);
	}
	
	public void delete(Long id) {
		userRepo.deleteById(id);
	}
}
