package com.bridgeit.toDoApp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SystemPropertyUtils;

import com.bridgeit.toDoApp.model.User;

/**
 * This is a simple DAO Implementation class. All Hibernate related action goes
 * here, operations related to 'Create, Insert, Update and Delete' are being
 * performed in appropriate methods for User Entity, we are getting session
 * object from an autowired sessionfactory
 * 
 * @version 1.8jdk
 * @since 2017-03-23
 * @author bridgeit
 *
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	 SessionFactory sessionFactory;

	 Session session = null;

	@Override
	public void addEntity(User user) throws Exception {
		session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	public User getEntityById(int id) throws Exception {
		
		session=sessionFactory.getCurrentSession();
		Criteria ctr = session.createCriteria(User.class);
		ctr.add(Restrictions.eq("id", id));
		User user=(User) ctr.uniqueResult();
		return user;
	}

	@Override
	public List<User> getUserList() throws Exception {
		session=sessionFactory.getCurrentSession();
		Criteria ctr = session.createCriteria(User.class);
		
		@SuppressWarnings("unchecked")
		List<User> list = ctr.list();
		
		return list;
	}

	@Override
	public void deleteEntity(int id) throws Exception {
		session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from User where id = :id");
		query.setParameter("id", id);
		int rowCount = query.executeUpdate(); 
		System.out.println(rowCount+" Data Deleted");
	}
	
}
