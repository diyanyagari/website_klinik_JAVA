/**
 * 
 */
package com.xsis.bootcamp.dao.impl;

import java.util.List;

import javax.management.relation.Role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.RoleDao;
import com.xsis.bootcamp.model.RoleModel;

/**
 * @author sharkbit_
 *
 */

@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory SessionFactory;
	
	@Override
	public List<RoleModel> get() throws Exception {
		Session session = this.SessionFactory.getCurrentSession();
		List<RoleModel> result = session.createQuery("from RoleModel").list();
		return result;
	}

	@Override
	public void insert(RoleModel model) throws Exception {
		Session session = this.SessionFactory.getCurrentSession();
		session.save(model);
	}

	@Override
	public RoleModel getById(int id) throws Exception {
		Session session = this.SessionFactory.getCurrentSession();
		RoleModel result = session.get(RoleModel.class, id);
		return result;
	}

	@Override
	public void update(RoleModel model) throws Exception {
		Session session = this.SessionFactory.getCurrentSession();
		session.update(model);
		
	}

	@Override
	public void delete(RoleModel model) throws Exception {
		Session session = this.SessionFactory.getCurrentSession();
		session.delete(model);
		
	}
	
}
