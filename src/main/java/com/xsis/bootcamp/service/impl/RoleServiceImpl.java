/**
 * 
 */
package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.RoleDao;
import com.xsis.bootcamp.model.RoleModel;
import com.xsis.bootcamp.service.RoleService;

/**
 * @author sharkbit_
 *
 */

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao dao;
	
	@Override
	public List<RoleModel> get() throws Exception {
		// TODO Auto-generated method stub
		return this.dao.get();
	}

	@Override
	public void insert(RoleModel model) throws Exception {
		// TODO Auto-generated method stub
		this.dao.insert(model);
	}

	@Override
	public RoleModel getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return this.dao.getById(id);
	}

	@Override
	public void update(RoleModel model) throws Exception {
		// TODO Auto-generated method stub
		this.dao.update(model);
	}

	@Override
	public void delete(RoleModel model) throws Exception {
		// TODO Auto-generated method stub
		this.dao.delete(model);
	}

}
