package com.bridgeit.toDoApp.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.toDoApp.model.Collaboration;
import com.bridgeit.toDoApp.model.ToDoTask;
import com.bridgeit.toDoApp.model.User;

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

	public void addToDoTask(ToDoTask todo) throws HibernateException {
		
		Session session = sessionFactory.getCurrentSession();
		
		/*String hql ="update ToDoTask set cardIndex=cardIndex+1";
		Query qry = session.createQuery(hql);
		qry.executeUpdate();
		*/
		
		session.saveOrUpdate(todo);
	}

	public List<ToDoTask> getToDoListByUserId(int userid) throws Exception {
		
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(ToDoTask.class);
		List<ToDoTask> list = ctr.add(Restrictions.eq("user.id", userid)).add(Restrictions.eq("archive", false)).list();
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

	public void deleteTaskByTODoId(int taskId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from ToDoTask where id = :id");
		query.setParameter("id", taskId);
		int rowCount = query.executeUpdate();
		System.out.println(rowCount + " Data Deleted");
	}
	
	public List<ToDoTask> getArchivedTOdoTask(int userId) throws Exception {
		
		Session session = sessionFactory.openSession();
		Criteria ctr = session.createCriteria(ToDoTask.class);
		List<ToDoTask> list = ctr.add(Restrictions.eq("user.id", userId)).add(Restrictions.eq("archive", true)).list();
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
	public void saveCollaboration(Collaboration col) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(col);
		
	}

	@Override
	public List<ToDoTask> getSharedTodo(int userId) throws Exception {
		
		try{
			Session session = sessionFactory.getCurrentSession();

			List<ToDoTask> sharedNotes = null;
			User user = new User();
			user.setId(userId);
			Criteria criteria = session.createCriteria(Collaboration.class);

			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("todo"));
			criteria.setProjection(projectionList);

			criteria.add(Restrictions.eq("shared_User", user));

			//System.out.println(criteria.list());

			sharedNotes = criteria.list();

			return sharedNotes;
		}
		catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void saveIndex(List<Map<String, Integer>> listOfIndex) throws HibernateException {
		
		String hql = "update ToDoTask set cardIndex=:index where id=:todoId";
		Session session = sessionFactory.getCurrentSession();
		Iterator<Map<String,Integer>> iterator = listOfIndex.iterator();

		while(iterator.hasNext()){
			HashMap<String, Integer> map = (HashMap<String, Integer>) iterator.next();

			Query query =session.createQuery(hql);
			query.setParameter("index", map.get("index"));
			query.setParameter("todoId", map.get("id"));
			query.executeUpdate();
			
		}
	}

	@Override
	public List<User> getSharedUser(User shareBy_user) throws HibernateException {
		try{
			Session session = sessionFactory.getCurrentSession();

			List<User> sharedUser = null;
			;
			Criteria criteria = session.createCriteria(Collaboration.class);

			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("shared_User"));
			criteria.setProjection(projectionList);

			criteria.add(Restrictions.eq("shared_by", shareBy_user));

			//System.out.println(criteria.list());

			sharedUser = criteria.list();

			return sharedUser;
		}
		catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteCollaborator(int taskId) {
		
		ToDoTask todo = new ToDoTask();
		todo.setId(taskId);
		
		String query = "DELETE FROM Collaboration WHERE todo =:todo";
		Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery(query);
        q.setParameter("todo", todo);
        q.executeUpdate();
		
		
	}
}
