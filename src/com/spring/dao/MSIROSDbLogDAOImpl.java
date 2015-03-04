package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.model.MSIROSDbLog;

public class MSIROSDbLogDAOImpl implements MSIROSDbLogDAO {
	private SessionFactory sessionfactory ;
	private void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	@Override
	public void save(MSIROSDbLog dblog) {
		Session session = this.sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(dblog);
		session.close();
		}

	@Override
	public List<MSIROSDbLog> getLogs() {
	Session session = this.sessionfactory.openSession();
	List<MSIROSDbLog> logList= session.createQuery("From Session").list();
	session.close();
	return logList;
	}	

}
