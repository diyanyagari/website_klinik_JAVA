package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.DetailKunjunganDao;
import com.xsis.bootcamp.model.DetailKunjunganModel;

@Repository
public class DetailKunjunganDaoImpl implements DetailKunjunganDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<DetailKunjunganModel> get() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<DetailKunjunganModel> result = session.createQuery("from DetailKunjunganModel").list();
		return result;
	}

	@Override
	public void insert(DetailKunjunganModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public DetailKunjunganModel getById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		DetailKunjunganModel result = session.get(DetailKunjunganModel.class, id);
		return result;
	}

	@Override
	public void update(DetailKunjunganModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(DetailKunjunganModel model) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.delete(model);
	}

}
