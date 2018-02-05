package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.PropinsiDao;
import com.xsis.bootcamp.model.PropinsiModel;
import com.xsis.bootcamp.service.PropinsiService;

@Service
@Transactional
public class PropinsiServiceImpl implements PropinsiService {
	@Autowired
	private PropinsiDao dao;
	
	@Override
	public List<PropinsiModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public void insert(PropinsiModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public PropinsiModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(PropinsiModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(PropinsiModel model) throws Exception {
		this.dao.delete(model);		
	}

}
