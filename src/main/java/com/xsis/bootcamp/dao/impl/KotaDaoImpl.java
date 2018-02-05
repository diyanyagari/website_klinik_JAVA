package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.KotaDao;
import com.xsis.bootcamp.model.KotaModel;
import com.xsis.bootcamp.model.KotaModel;

@Repository
public class KotaDaoImpl implements KotaDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<KotaModel> get() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<KotaModel> result = session.createQuery("from KotaModel").list();
		return result;
	}
	
	@Override
	public List<KotaModel> getByPropinsiId(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(KotaModel.class);
		criteria.add(Restrictions.eq("propinsiId",id));
		List<KotaModel> result = criteria.list();
		return result;
	}

	@Override
	public void insert(KotaModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public KotaModel getById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		KotaModel result = session.get(KotaModel.class, id);
		
		return result;
	}

	@Override
	public void update(KotaModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(KotaModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(model);
	}

}
