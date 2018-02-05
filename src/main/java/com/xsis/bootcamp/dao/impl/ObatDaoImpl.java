package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.ObatDao;
import com.xsis.bootcamp.model.ObatModel;

@Repository
public class ObatDaoImpl implements ObatDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ObatModel> get() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<ObatModel> result = session.createQuery("from ObatModel").list();
		return result;
	}

	@Override
	public void insert(ObatModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public ObatModel getById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		ObatModel result = session.get(ObatModel.class, id);
		
		return result;
	}

	@Override
	public void update(ObatModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(ObatModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(model);
	}

}
