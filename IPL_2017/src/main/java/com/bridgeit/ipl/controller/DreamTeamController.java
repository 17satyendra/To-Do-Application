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
import com.bridgeit.ipl.service.UserService;

@Controller
@RequestMapping("/")
public class DreamTeamController 
{
	@Autowired
	PlayerService playerservice;
	@Autowired
	TeamService teamService;
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="createTeam")
	public ModelAndView createTeam(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		if(userservice.isUserIdPresent(((User) session.getAttribute("user")).getId())==false){
			List<Player> playerList = playerservice.displayAllPlayer();
			return new ModelAndView("createNewTeam", "playerList", playerList);
		}
		else{
			System.out.println("A Dream Team is Already Exist of User...");
			return new ModelAndView();
		}
			
		
		
	}
	@RequestMapping(value="saveDreamTeam", method=RequestMethod.POST)
	public String addNewTeam(@RequestParam("Player") String[] player, @RequestParam("dreamTeamName")
					String dreamTeamName, HttpServletRequest request ){
		
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		DreamTeam dt = new DreamTeam();
		dt.setUser(user);
		dt.setDreamTeamName(dreamTeamName);
		dt.setPlayerList(playerservice.getPlayerList(player));
		
		
	
		teamService.addDreamTeam(dt);
		
		return "redirect:/teamList";
		
	}
	@RequestMapping(value ="viewDreamList")
	public ModelAndView getDreamTeam(){
		System.out.println("inside getDreamTeam");
		List<DreamTeam> dreamList=teamService.getDreamTeamList();
		return new ModelAndView("viewDreamTeamList", "dreamList", dreamList);
	}
	
	
}
