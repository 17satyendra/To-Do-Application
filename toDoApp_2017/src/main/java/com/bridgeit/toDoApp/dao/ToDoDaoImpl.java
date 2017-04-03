package com.bridgeit.toDoApp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.toDoApp.model.ToDoTask;

/**
 * This is a simple DAO Implementation class. All Hibernate related action goes
 * here, operations related to 'Create, Insert, Update and Delete' are being
 * performed in appropriate methods for ToDoTask Entity, we are getting session
 * object from an @autowired SessionFactory, @Repository('a mechanism for
 * encapsulating storage, retrieval, and search behavior which emulates a
 * collection of objects') and by @Transactional we get transaction criteria.
 * 
 * @version 1.8jdk
 * @since 2017-03-23
 * @author bridgeit
 */
@Repository
@Transactional
public class ToDoDaoImpl implements ToDoDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addToDoTask(ToDoTask todo) throws HibernateException {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(todo);
	}

	@Override
	public List<ToDoTask> getToDoListByUserId(int userid) throws Exception {
		
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(ToDoTask.class);
		List<ToDoTask> list = ctr.add(Restrictions.eq("user.id", userid)).list();
		session.close();
		
		if( list != null)
		{
			for (ToDoTask toDoTask : list) {
				if( toDoTask.getUser() != null){
					toDoTask.setUser(null);
				}
			}
		}
		
		return list;
	}

	@Override
	public void deleteTaskByTODoId(int taskId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from ToDoTask where id = :id");
		query.setParameter("id", taskId);
		int rowCount = query.executeUpdate();
		System.out.println(rowCount + " Data Deleted");
	}

}
