package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.DetailKunjunganDao;
import com.xsis.bootcamp.model.DetailKunjunganModel;
import com.xsis.bootcamp.service.DetailKunjunganService;

@Service
@Transactional
public class DetailKunjunganServiceImpl implements DetailKunjunganService {
	@Autowired
	private DetailKunjunganDao dao;
	
	@Override
	public List<DetailKunjunganModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public void insert(DetailKunjunganModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public DetailKunjunganModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(DetailKunjunganModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(DetailKunjunganModel model) throws Exception {
		this.dao.delete(model);		
	}

}
