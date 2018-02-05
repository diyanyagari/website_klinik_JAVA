package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.PasienDao;
import com.xsis.bootcamp.model.PasienModel;
import com.xsis.bootcamp.service.PasienService;

@Service
@Transactional
public class PasienServiceImpl implements PasienService {
	@Autowired
	private PasienDao dao;
	
	@Override
	public List<PasienModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public void insert(PasienModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public PasienModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(PasienModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(PasienModel model) throws Exception {
		this.dao.delete(model);		
	}

}
