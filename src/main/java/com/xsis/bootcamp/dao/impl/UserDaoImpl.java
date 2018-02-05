/**
 * 
 */
package com.xsis.bootcamp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.bootcamp.dao.UserDao;
import com.xsis.bootcamp.model.UserModel;

/**
 * @author sharkbit_
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory SessionFactory;
	
	
	
	@Override
	public List<UserModel> get() throws Exception {
		Session session = this.SessionFactory.getCurrentSession();
		List<UserModel> result = session.createQuery("from UserModel").list();
		return result;
	}

	@Override
	public void Insert(UserModel model) throws Exception {
		Session session = this.SessionFactory.getCurrentSession();
		session.save(model);
		
	}

	@Override
	public UserModel getById(int id) throws Exception {
		Session session = this.SessionFactory.getCurrentSession();
		UserModel result = session.get(UserModel.class, id);
		return result;
	}

	@Override
	public void update(UserModel model) throws Exception {
		Session session = this.SessionFactory.getCurrentSession();
		session.update(model);
	}

	@Override
	public void delete(UserModel model) throws Exception {
		Session session = this.SessionFactory.getCurrentSession();
		session.delete(model);
		
	}

}
