/**
 * 
 */
package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.UserDao;
import com.xsis.bootcamp.model.UserModel;
import com.xsis.bootcamp.service.UserService;

/**
 * @author sharkbit_
 *
 */

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	
	@Override
	public List<UserModel> get() throws Exception {
		// TODO Auto-generated method stub
		return this.dao.get();
	}

	@Override
	public void insert(UserModel model) throws Exception {
		// TODO Auto-generated method stub
		this.dao.Insert(model);
	}

	@Override
	public UserModel getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.getById(id);
	}

	@Override
	public void update(UserModel model) throws Exception {
		// TODO Auto-generated method stub
		this.dao.update(model);
	}

	@Override
	public void delete(UserModel model) throws Exception {
		// TODO Auto-generated method stub
		this.dao.delete(model);
	}
	
}
