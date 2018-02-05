package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.KotaDao;
import com.xsis.bootcamp.model.KotaModel;
import com.xsis.bootcamp.service.KotaService;

@Service
@Transactional
public class KotaServiceImpl implements KotaService {
	@Autowired
	private KotaDao dao;
	
	@Override
	public List<KotaModel> get() throws Exception {
		return this.dao.get();
	}
	
	@Override
	public List<KotaModel> getByPropinsiId(int id) throws Exception {
		return this.dao.getByPropinsiId(id);
	}

	@Override
	public void insert(KotaModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public KotaModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(KotaModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(KotaModel model) throws Exception {
		this.dao.delete(model);		
	}

}
