package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.PenyakitDao;
import com.xsis.bootcamp.model.PenyakitModel;

@Repository
public class PenyakitDaoImpl implements PenyakitDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PenyakitModel> get() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<PenyakitModel> result = session.createQuery("from PenyakitModel").list();
		return result;
	}

	@Override
	public void insert(PenyakitModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public PenyakitModel getById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		PenyakitModel result = session.get(PenyakitModel.class, id);
		
		return result;
	}

	@Override
	public void update(PenyakitModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(PenyakitModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(model);
	}

}
