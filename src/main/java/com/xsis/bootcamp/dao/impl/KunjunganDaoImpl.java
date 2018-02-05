package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.KunjunganDao;
import com.xsis.bootcamp.model.KunjunganModel;

@Repository
public class KunjunganDaoImpl implements KunjunganDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<KunjunganModel> get() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<KunjunganModel> result = session.createQuery("from KunjunganModel").list();
		return result;
	}

	@Override
	public void insert(KunjunganModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public KunjunganModel getById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		KunjunganModel result = session.get(KunjunganModel.class, id);
		return result;
	}

	@Override
	public void update(KunjunganModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
		
	}

	@Override
	public void delete(KunjunganModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(model);
	}

}
