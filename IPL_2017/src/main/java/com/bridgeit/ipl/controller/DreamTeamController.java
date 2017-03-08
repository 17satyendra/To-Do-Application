package com.bridgeit.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.ipl.model.Player;
import com.bridgeit.ipl.service.PlayerService;

@Controller
@RequestMapping("/")
public class DreamTeamController 
{
	@Autowired
	PlayerService playerservice;
	
	@RequestMapping(value="createTeam")
	public ModelAndView createTeam(){
		List<Player> playerList = playerservice.displayAllPlayer();
		return new ModelAndView("createNewTeam", "playerList", playerList);
		
	}
}
