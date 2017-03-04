package com.bridgeit.ipl.controller;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.ipl.model.Team;
import com.bridgeit.ipl.service.TeamService;

@Controller
@RequestMapping("/")
public class TeamController {
	@Autowired
	TeamService teamService;

	@RequestMapping(value = "/newAddTeam", method = RequestMethod.GET)
	public String newAddTeam() {

		Team tem;
		JSONParser parser = new JSONParser();
		try {
			Object ob = parser.parse(new FileReader("/home/bridgeit/newTeamInfo.json"));
			JSONObject object = (JSONObject) ob;

			JSONArray data = (JSONArray) object.get("teaminfo");

			for (int i = 0; i < data.size(); i++) {
				tem = new Team();
				JSONObject itemObj = (JSONObject) data.get(i);

				Object nameObj = itemObj.get("team_name");
				String teamName = (String) nameObj;
				tem.setName(teamName);

				Object coachObj = itemObj.get("team_coach");
				String coachName = (String) coachObj;
				tem.setCoach(coachName);

				Object capatainObj = itemObj.get("team_captain");
				String capatainName = (String) capatainObj;
				tem.setCaptain(capatainName);

				Object venueObj = itemObj.get("team_home_venue");
				String venueName = (String) venueObj;
				tem.setHomevenue(venueName);

				Object ownerObj = itemObj.get("team_owner");
				String ownerName = (String) ownerObj;
				tem.setOwner(ownerName);

				Object logoObj = itemObj.get("team_img_url");
				String logoName = (String) logoObj;
				tem.setLogo(logoName);
				teamService.addTeam(tem);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return "signin";
	}
	
	@RequestMapping(value="upload", method=RequestMethod.GET)
	public String init()
	{
		return "fileUpload";
	}
	
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile file){
		String fileName=file.getOriginalFilename();
		System.out.println(fileName);
		
		Team tem;
		JSONParser parser = new JSONParser();
		try {
			Object ob = parser.parse(new FileReader(fileName));
			JSONObject object = (JSONObject) ob;

			JSONArray data = (JSONArray) object.get("teaminfo");

			for (int i = 0; i < data.size(); i++) {
				tem = new Team();
				JSONObject itemObj = (JSONObject) data.get(i);

				Object nameObj = itemObj.get("team_name");
				String teamName = (String) nameObj;
				tem.setName(teamName);

				Object coachObj = itemObj.get("team_coach");
				String coachName = (String) coachObj;
				tem.setCoach(coachName);

				Object capatainObj = itemObj.get("team_captain");
				String capatainName = (String) capatainObj;
				tem.setCaptain(capatainName);

				Object venueObj = itemObj.get("team_home_venue");
				String venueName = (String) venueObj;
				tem.setHomevenue(venueName);

				Object ownerObj = itemObj.get("team_owner");
				String ownerName = (String) ownerObj;
				tem.setOwner(ownerName);

				Object logoObj = itemObj.get("team_img_url");
				String logoName = (String) logoObj;
				tem.setLogo(logoName);
				teamService.addTeam(tem);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return "signin";
	}
	
	@RequestMapping(value="teamList", method=RequestMethod.GET)
	public ModelAndView displayAllTeam(){
		List<Team> teamInfo = teamService.displayAllTeam();
		return new ModelAndView("teamList", "teamInfo", teamInfo);
	}
	
	@RequestMapping(value="teamDetails", method=RequestMethod.GET)
	public ModelAndView displayTeamDetails(@RequestParam("teamName")String name, Model model){
		
		System.out.println(name);
		List<Team> teamDetails = teamService.displayTeamInfo(name);
		
		return new ModelAndView("teamDetails","teamDetails", teamDetails);
	}
}
