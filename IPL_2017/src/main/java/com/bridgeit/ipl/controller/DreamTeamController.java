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

/**
 * This class basically Controller for DreamTeam.
 * 
 * @author bridgeit Satyendra Singh
 * @version 1.8
 * @since 2017-03-01
 */
@Controller
@RequestMapping("/")
public class DreamTeamController {
	@Autowired
	PlayerService playerservice;
	@Autowired
	TeamService teamService;
	@Autowired
	UserService userservice;

	/**
	 * In this method we r provide session and get user for checking dreamTeam
	 * Created or not if already created then return ModelAndView with message(A
	 * Dream Team is Already Exist of User..) otherwise return ModelAndView with
	 * createNewTeam.jsp and playerlist.
	 * @param request
	 *            for Session request
	 * @return createNewTeam.
	 */
	@RequestMapping(value = "createTeam")
	public ModelAndView createTeam(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (userservice.ispresentTeam(((User) session.getAttribute("user")).getId()) == false) {
			List<Player> playerList = playerservice.displayAllPlayer();
			return new ModelAndView("createNewTeam", "playerList", playerList);
		} else {
			System.out.println("A Dream Team is Already Exist of User...");
			return new ModelAndView();
		}
	}

	/**
	 * In this method We have to create new DreamTeam by User.
	 * We get User from session and set into DreamTeam Object and pass to service layer tobe save. 
	 * @param player String[] its contain playerId
	 * @param dreamTeamName 
	 * @param request for Session
	 * @return redirect to TeamController for teamList.
	 */
	@RequestMapping(value = "saveDreamTeam", method = RequestMethod.POST)
	public String addNewTeam(@RequestParam("Player") String[] player,
			@RequestParam("dreamTeamName") String dreamTeamName, HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		DreamTeam dt = new DreamTeam();
		dt.setUser(user);
		dt.setDreamTeamName(dreamTeamName);
		dt.setPlayerList(playerservice.getPlayerList(player));
		teamService.addDreamTeam(dt);

		return "redirect:/teamList";

	}

	/**
	 * In this method get the Dream Team List Based on User, with the help of UserId.
	 * @param request For Session
	 * @return ModelAndView with dreamTeam object ref.
	 */
	@RequestMapping(value = "viewDreamTeam")
	public ModelAndView getDreamTeam(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		DreamTeam dreamTeam = userservice.getDreamTeam(((User) session.getAttribute("user")).getId());
		return new ModelAndView("viewDreamTeam", "dreamTeam", dreamTeam);
	}

	/**
	 * In this Method show the DreamTeam Details who created by User.
	 * We have to fetch the details from database based on the dreamTeamid. 
	 * @param id DreamTeam Id
	 * @param request for Session
	 * @return ModelAndView with DreamTeamDetails.jsp and DreamTeamObject.
	 */
	@RequestMapping(value = "dreamTeamDetails")
	public ModelAndView showDreamTeamDetail(@RequestParam("dreamteamId") int id, HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		DreamTeam team = teamService.getDreamTeamDetail(id);
		ModelAndView mvc = new ModelAndView("dreamTeamDetail", "team", team);
		mvc.addObject("user", user);
		return mvc;

	}
}
