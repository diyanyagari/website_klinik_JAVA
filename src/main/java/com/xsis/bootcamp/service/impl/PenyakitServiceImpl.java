package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.PenyakitDao;
import com.xsis.bootcamp.model.PenyakitModel;
import com.xsis.bootcamp.service.PenyakitService;

@Service
@Transactional
public class PenyakitServiceImpl implements PenyakitService {
	@Autowired
	private PenyakitDao dao;
	
	@Override
	public List<PenyakitModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public void insert(PenyakitModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public PenyakitModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(PenyakitModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(PenyakitModel model) throws Exception {
		this.dao.delete(model);		
	}

}
