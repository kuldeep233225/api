package com.example.reposetry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.UserEntity;

@Repository
public interface Reposetrayy extends JpaRepository<UserEntity, Long> {

}
