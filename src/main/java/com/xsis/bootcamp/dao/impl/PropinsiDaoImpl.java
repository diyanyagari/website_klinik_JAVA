package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.PropinsiDao;
import com.xsis.bootcamp.model.PropinsiModel;

@Repository
public class PropinsiDaoImpl implements PropinsiDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PropinsiModel> get() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<PropinsiModel> result = session.createQuery("from PropinsiModel").list();
		return result;
	}

	@Override
	public void insert(PropinsiModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public PropinsiModel getById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		PropinsiModel result = session.get(PropinsiModel.class, id);
		
		return result;
	}

	@Override
	public void update(PropinsiModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(PropinsiModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(model);
	}

}
