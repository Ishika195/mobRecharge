package com.example.MobRecharge.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MobRecharge.entity.Plan;
import com.example.MobRecharge.entity.User;
import com.example.MobRecharge.exceptions.InvalidArguementsException;
import com.example.MobRecharge.exceptions.ResourceNotFoundException;
import com.example.MobRecharge.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public Long saveUser(User user) {
		if (user == null) {
			throw new InvalidArguementsException("Empty Object");
		}
		userRepository.save(user);
		return user.getUserId();
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(Long id) {
		if (id <= 0) {
			throw new InvalidArguementsException("Invalid Id");
		}
		userRepository.deleteById(id);
	}

	public User updateUser(Long id, User user) {
		if (id == 0 || user == null) {
			throw new InvalidArguementsException("bad arguement");
		}
		try {
			User existingUser = userRepository.findByUserId(id);
			if (existingUser == null) {
				throw new ResourceNotFoundException("user not found");
			}
			if (user.getFirstName() != null) {
				existingUser.setFirstName(user.getFirstName());
			}
			if (user.getLastName() != null) {
				existingUser.setLastName(user.getLastName());
			}
			if (user.getEmail() != null) {
				existingUser.setLastName(user.getEmail());
			}
			if (user.getMobileNumber() != null) {
				existingUser.setMobileNumber(user.getMobileNumber());
			}
			if (user.getDateOfBirth() != null) {
				existingUser.setDateOfBirth(user.getDateOfBirth());
			}
			if (user.getGender() != null) {
				existingUser.setGender(user.getGender());
			}
			userRepository.save(existingUser);
			return existingUser;
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("user not found");
		}

	}

	@SuppressWarnings("unchecked")
	public List<Plan> getAllPlans(Long id){
		if (id <= 0) {
			throw new InvalidArguementsException("Invalid Id");
		}
		User user = userRepository.findByUserId(id);
		if(user==null) {
			throw new ResourceNotFoundException("user not found");
		}
		return (List<Plan>) user.getPlans();
	}
}
