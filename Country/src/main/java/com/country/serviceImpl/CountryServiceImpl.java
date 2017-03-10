package com.country.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.country.dao.CountryDao;
import com.country.model.Country;
import com.country.service.CountryService;
@Component
public class CountryServiceImpl implements CountryService {
@Autowired
CountryDao countryDao;
	@Override
	public void saveCountry(Country country) {
		countryDao.saveCountry(country);
		
	}
	@Override
	public Collection<Country> getAllCountries() {
		
		return countryDao.getAll();
	}
	@Override
	public Country getCountryById(int countryId) {
		return countryDao.getCountryById(countryId);
	}
	@Override
	public void deleteCountry(int countryId) {
		countryDao.deleteCountry(countryId);
	}

}
