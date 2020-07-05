package com.telusko.practice_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telusko.practice_jpa.dao.Alien;
import com.telusko.practice_jpa.repo.AlienRepo;

@Component
public class AlienService {

	@Autowired
	public AlienRepo alienRepo;
	
	public Alien alienDelete(int aid) {
		Alien deleteAlien = alienRepo.findById(aid).orElse(new Alien());
		if(deleteAlien.getAid() != 0) {
			alienRepo.delete(deleteAlien);
		}
		return deleteAlien;
	}
	
	public String objectCreation() {
		return "object created in service";
	}
}
