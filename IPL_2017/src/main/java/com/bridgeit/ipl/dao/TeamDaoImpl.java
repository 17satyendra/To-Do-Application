	package com.bridgeit.ipl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.ipl.model.DreamTeam;
import com.bridgeit.ipl.model.Team;
@Repository
@Transactional
public class TeamDaoImpl implements TeamDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addNewTeam(Team team) {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(team);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Team> displayAllTeam() {
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery("from Team");
		List<Team> teamsinfo = qry.list();
		return teamsinfo;
	}
	@Override
	public String getTeamName(String name) {
		
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery("from Team where name=:name");
		qry.setParameter("name", name);
		String teamName = (String) qry.uniqueResult();
		return teamName;
	}
	@Override
	public Team getTeamById(long teamId) {
		
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.createQuery("from Team where id=:teamId");
		qry.setParameter("teamId", teamId);
		Team team = (Team) qry.uniqueResult();
		return team;
	}
	@Override
	public void addDreamTeam(DreamTeam dt) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(dt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<DreamTeam> getDreamTeamList() 
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria ctr = session.createCriteria(DreamTeam.class);
		List<DreamTeam> list = ctr.list();
		return list;
	}
	
}
