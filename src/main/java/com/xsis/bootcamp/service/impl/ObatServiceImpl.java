package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.ObatDao;
import com.xsis.bootcamp.model.ObatModel;
import com.xsis.bootcamp.service.ObatService;

@Service
@Transactional
public class ObatServiceImpl implements ObatService {
	@Autowired
	private ObatDao dao;
	
	@Override
	public List<ObatModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public void insert(ObatModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public ObatModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(ObatModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(ObatModel model) throws Exception {
		this.dao.delete(model);		
	}

}
