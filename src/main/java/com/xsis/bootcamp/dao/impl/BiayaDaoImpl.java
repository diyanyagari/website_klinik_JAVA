package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.BiayaDao;
import com.xsis.bootcamp.model.BiayaModel;

@Repository
public class BiayaDaoImpl implements BiayaDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<BiayaModel> get() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<BiayaModel> result = session.createQuery("from BiayaModel").list();
		return result;
	}

	@Override
	public void insert(BiayaModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public BiayaModel getById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		BiayaModel result = session.get(BiayaModel.class, id);
		
		return result;
	}

	@Override
	public void update(BiayaModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(BiayaModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(model);
	}

}
