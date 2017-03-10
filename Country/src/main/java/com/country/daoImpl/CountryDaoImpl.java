package com.country.daoImpl;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.dao.CountryDao;
import com.country.model.Country;
@Repository
@Transactional
public class CountryDaoImpl implements CountryDao {
    @Autowired
	SessionFactory sessionFactory;
    
    
	@Override
	public void saveCountry(Country country) {
		Session sess=sessionFactory.getCurrentSession();
		//sess.save(country);
		sess.saveOrUpdate(country);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Collection<Country> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Country").list();
	}


	@Override
	public Country getCountryById(int countryId) {
		return (Country)sessionFactory.getCurrentSession().get(Country.class, countryId);
	}


	@Override
	public void deleteCountry(int countryId) {
		System.out.println(countryId);
		Country c=(Country)sessionFactory.getCurrentSession().get(Country.class, countryId);
		sessionFactory.getCurrentSession().delete(c);
		
	}

}
