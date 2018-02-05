package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.BiayaDao;
import com.xsis.bootcamp.model.BiayaModel;
import com.xsis.bootcamp.service.BiayaService;

@Service
@Transactional
public class BiayaServiceImpl implements BiayaService {
	@Autowired
	private BiayaDao dao;
	
	@Override
	public List<BiayaModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public void insert(BiayaModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public BiayaModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(BiayaModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(BiayaModel model) throws Exception {
		this.dao.delete(model);		
	}

}
