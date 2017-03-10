package com.bridgeit.ipl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.ipl.model.DreamTeam;
import com.bridgeit.ipl.model.Player;
import com.bridgeit.ipl.model.User;
import com.bridgeit.ipl.service.PlayerService;
import com.bridgeit.ipl.service.TeamService;

@Controller
@RequestMapping("/")
public class DreamTeamController 
{
	@Autowired
	PlayerService playerservice;
	@Autowired
	TeamService teamService;
	
	@RequestMapping(value="createTeam")
	public ModelAndView createTeam(){
		List<Player> playerList = playerservice.displayAllPlayer();
		return new ModelAndView("createNewTeam", "playerList", playerList);
	}
	@RequestMapping(value="saveDreamTeam", method=RequestMethod.POST)
	public String addNewTeam(@RequestParam("Player") String[] player, @RequestParam("dreamTeamName")
					String dreamTeamName, HttpServletRequest request ){
		
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		DreamTeam dt = new DreamTeam();
		dt.setUser(user);
		dt.setUserId(user.getId());
		dt.setDreamTeamName(dreamTeamName);
		teamService.addDreamTeam(dt);
		
		return "teamList";
		
	}
	
	
}
