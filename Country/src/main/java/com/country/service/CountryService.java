package com.country.service;

import java.util.Collection;

import com.country.model.Country;

public interface CountryService {

	
	public void saveCountry(Country country);

	public Collection<Country> getAllCountries();

	public Country getCountryById(int countryId);

	public void deleteCountry(int countryId);
}
