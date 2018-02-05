package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.KecamatanDao;
import com.xsis.bootcamp.model.KecamatanModel;
import com.xsis.bootcamp.model.KecamatanModel;

@Repository
public class KecamatanDaoImpl implements KecamatanDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<KecamatanModel> get() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<KecamatanModel> result = session.createQuery("from KecamatanModel").list();
		return result;
	}
	
	@Override
	public List<KecamatanModel> getByKotaId(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(KecamatanModel.class);
		criteria.add(Restrictions.eq("kotaId",id));
		List<KecamatanModel> result = criteria.list();
		return result;
	}

	@Override
	public void insert(KecamatanModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public KecamatanModel getById(int id) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		KecamatanModel result = session.get(KecamatanModel.class, id);
		
		return result;
	}

	@Override
	public void update(KecamatanModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(KecamatanModel model) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(model);
	}

}
