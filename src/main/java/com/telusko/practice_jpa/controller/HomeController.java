package com.telusko.practice_jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.practice_jpa.dao.Alien;
import com.telusko.practice_jpa.repo.AlienRepo;
import com.telusko.practice_jpa.service.AlienService;

@Controller
public class HomeController {
	
	@Autowired
	private AlienRepo alienRepo;
	
	@Autowired
	private AlienService alienService;
	
	@RequestMapping(path="/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(path="/getAlien")
	public ModelAndView getAlien(@RequestParam("aid") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Alien alien = alienRepo.findById(id).orElse(new Alien());
		modelAndView.addObject("Alien", alien);
		modelAndView.setViewName("showAlien");
		return modelAndView;
	}
	@RequestMapping(path="/addAlien")
	public ModelAndView addAlien(Alien alien) {
		ModelAndView modelAndView = new ModelAndView();
		alienRepo.save(alien);
		modelAndView.addObject("Alien", alien);
		modelAndView.setViewName("showAlien");
		return modelAndView;
	}
	
	@GetMapping(path="/aliens", produces={"application/xml"})
	@ResponseBody
	public List<Alien> aliens() {
		List<Alien> alienList = alienRepo.findAll();
		return alienList;
	}
	
	@GetMapping(path="/aliens/{aid}")
	@ResponseBody
	public Alien getAlienThroughPostMan(@PathVariable("aid") int aid) {
		Alien alien = alienRepo.findById(aid).orElse(new Alien());
		return alien;
	}

	@PostMapping(path="/aliens", consumes={"multipart/form-data"})
	@ResponseBody
	public Alien addAlienThroughPostMan(@RequestBody Alien alien) {
		Alien savedAlien = alienRepo.save(alien);
		return savedAlien;
	}
	
	@PutMapping(path="/aliens")
	@ResponseBody
	public Alien addOrUpdate(@RequestBody Alien alien) {
		Alien savedAlien = alienRepo.save(alien);
		return savedAlien;
	}
	
	@DeleteMapping(path="/aliens/{aid}")
	@ResponseBody
	public Alien deleteAlien(@PathVariable("aid") int aid) {
		return alienService.alienDelete(aid);
	}
}
