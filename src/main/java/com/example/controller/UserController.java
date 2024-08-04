package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserEntity;

import com.example.service.UserService;

@RestController
@RequestMapping("/apidata")
public class UserController {
	//post data
	@Autowired
	private UserService sarvis;
	@PostMapping ("/postdata")
	public ResponseEntity<UserEntity> data(@RequestBody UserEntity use )
	{
		UserEntity ataSave = sarvis.dataSave(use);
		return new ResponseEntity<UserEntity>(ataSave,HttpStatus.CREATED);
	}
	@GetMapping("/get/{userId}")
	public ResponseEntity<?> getData(@PathVariable Long userId)
	{
		//galat user id put karne par message show hoga
		UserEntity user = sarvis.getData(userId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public List<UserEntity> getAllData() {
		return sarvis.getAllData();
	}
	
	@PutMapping("/update/{id}")
	public UserEntity update (@RequestBody UserEntity user, @PathVariable ("id") Long IdNumber)
	{
		return sarvis.update(user, IdNumber);
	}
	
	@DeleteMapping("/delete/{IdNumber}")
	public ResponseEntity<String> deleteData(@PathVariable Long IdNumber)
	{
		//galat user id put karne par message show hoga
		String deleteData = sarvis.deleteData(IdNumber);
		return new ResponseEntity<String> (deleteData,HttpStatus.NO_CONTENT);
	}

}
