package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.DokterDao;
import com.xsis.bootcamp.model.DokterModel;

@Repository
public class DokterDaoImpl implements DokterDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<DokterModel> get() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<DokterModel> result = session.createQuery("from DokterModel").list();
		return result;
	}

	@Override
	public void insert(DokterModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public DokterModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		DokterModel result = session.get(DokterModel.class, id);
		return result;
	}

	@Override
	public void update(DokterModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delet(DokterModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

}
