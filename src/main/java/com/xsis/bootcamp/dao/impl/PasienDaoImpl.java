package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.PasienDao;
import com.xsis.bootcamp.model.PasienModel;

@Repository
public class PasienDaoImpl implements PasienDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PasienModel> get() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<PasienModel> result = session.createQuery("from PasienModel").list();
		return result;
	}

	@Override
	public void insert(PasienModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public PasienModel getById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		PasienModel result = session.get(PasienModel.class, id);
		
		return result;
	}

	@Override
	public void update(PasienModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(PasienModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(model);
	}

}
