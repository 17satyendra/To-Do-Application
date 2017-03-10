package com.country.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.country.model.Country;
import com.country.service.CountryService;

@Controller
@RequestMapping("/")
public class CountryController {

	@Autowired
	CountryService countryService;

	@RequestMapping(value= "/createCountry", method=RequestMethod.GET)
	public ModelAndView createCountry(Model model)
	{
		Country country = new Country();
		model.addAttribute(country);
		
		return new ModelAndView("createCountry");
	}
	
	
	// This shows UI with values to be updated 
	@RequestMapping(value="/update")
	public ModelAndView updateCountry(@RequestParam(value = "id", required = true) int countryId) {
		Country c=countryService.getCountryById(countryId);
		ModelAndView mvc = new ModelAndView("createCountry");
		mvc.addObject(c);
		return mvc;
	}
	
	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public ModelAndView saveCountry(@ModelAttribute("country") Country country, BindingResult result) {
		//System.out.println(country.getId());
		//if( country.getId() )
		countryService.saveCountry(country);
		return new ModelAndView("success");

	}

	/*
	 * @RequestMapping(value ="listOfCountries.html")
	 * 
	 * @ModelAttribute("countries") public ModelAndView showList(Model model) {
	 * Collection<Country>countryList=countryService.getAllCountries();
	 * System.out.println(countryList.toString()); return new
	 * ModelAndView("listOfCountries","countryList",countryList); }
	 */
	@RequestMapping("listOfCountries")
	@ModelAttribute("countries")
	public Collection<Country> getCountries() {
		return countryService.getAllCountries();
	}

	@RequestMapping("countryDetails")
	public Country getCountry(@RequestParam(value = "id", required = true) int countryId) {
		return countryService.getCountryById(countryId);
	}

	@RequestMapping("delete")
	public ModelAndView deleteCountry(@RequestParam(value = "id", required = true) int countryId) {
		countryService.deleteCountry(countryId);
		System.out.println("Country Id"+countryId);
		return new ModelAndView("redirect:listOfCountries");
	}

}
