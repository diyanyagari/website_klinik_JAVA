package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.DokterDao;
import com.xsis.bootcamp.model.DokterModel;
import com.xsis.bootcamp.service.DokterService;

@Service
@Transactional
public class DokterServiceImpl implements DokterService {
	@Autowired
	private DokterDao dao;
	
	@Override
	public List<DokterModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public void insert(DokterModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public DokterModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(DokterModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(DokterModel model) throws Exception {
		this.dao.delet(model);
	}

}
