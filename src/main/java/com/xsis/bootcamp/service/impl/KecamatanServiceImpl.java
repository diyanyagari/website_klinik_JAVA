package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.KecamatanDao;
import com.xsis.bootcamp.model.KecamatanModel;
import com.xsis.bootcamp.service.KecamatanService;

@Service
@Transactional
public class KecamatanServiceImpl implements KecamatanService {
	@Autowired
	private KecamatanDao dao;
	
	@Override
	public List<KecamatanModel> get() throws Exception {
		return this.dao.get();
	}
	
	@Override
	public List<KecamatanModel> getByKotaId(int id) throws Exception {
		return this.dao.getByKotaId(id);
	}

	@Override
	public void insert(KecamatanModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public KecamatanModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(KecamatanModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(KecamatanModel model) throws Exception {
		this.dao.delete(model);		
	}

}
