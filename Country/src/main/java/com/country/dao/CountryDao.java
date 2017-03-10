package com.country.dao;

import java.util.Collection;

import com.country.model.Country;

public interface CountryDao {
	
	
public void saveCountry(Country country);

public Collection<Country> getAll();

public Country getCountryById(int countryId);

public void deleteCountry(int countryId);
}
