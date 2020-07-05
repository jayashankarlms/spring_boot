package com.telusko.practice_jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.practice_jpa.dao.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{

}
