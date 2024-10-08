package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.UserEntity;
import com.example.exception.ResourceNotFoundException;
import com.example.reposetry.Reposetrayy;
	//post data
@Service
public class UserService 
{

	@Autowired
	private Reposetrayy repo;
	public UserEntity dataSave (UserEntity entity)
	{
		//save word connect class file
		UserEntity sav = repo.save(entity);
		return sav;
	}
	
	//one data show
	public UserEntity getData(Long userId)
	{
		return repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("UserEntity", "ID", userId));
	}
	
	public List<UserEntity> getAllData() 
	{
		return repo.findAll();
	}
	//update data
	public UserEntity update(UserEntity user, Long IdNumber)
	{
		UserEntity byId = repo.findById(IdNumber).get();
		
		byId.setName(user.getName());
		byId.setFatherName(user.getFatherName());
		byId.setMobile(user.getMobile());
		byId.setGmail(user.getGmail());
		return repo.save(byId);
		
		
	}
	
	public String deleteData(Long IdNumber)
	{
		UserEntity byId = repo.findById(IdNumber).orElseThrow(() -> new ResourceNotFoundException("UserEntity", "Id", IdNumber));
		repo.delete(byId);
		return "data delete from database";
	}
	
	
	
	
	
}
