package com.bridgeit.ipl.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.ipl.model.DreamTeam;
import com.bridgeit.ipl.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory factory;

	@Override
	public void addUserINDao(User user) {
		Session session = factory.getCurrentSession();
		try {
			session.saveOrUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User authUser(String email, String password) {
		Session session = factory.getCurrentSession();
		try {
			Criteria ctr = session.createCriteria(User.class);
			User user = (User) ctr.add(Restrictions.conjunction().add(Restrictions.eq("email", email))
					.add(Restrictions.eq("password", password))).uniqueResult();
			return user;
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isPresentId(int id) {
		Session session = factory.getCurrentSession();

		DreamTeam user = (DreamTeam) session.load(DreamTeam.class, id);

		if (user != null) {
			return true;
		} else

			return false;
	}
}
