package com.xsis.bootcamp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.bootcamp.dao.KunjunganDao;
import com.xsis.bootcamp.model.KunjunganModel;
import com.xsis.bootcamp.service.KunjunganService;

@Service
@Transactional
public class KunjunganServiceImpl implements KunjunganService {
	@Autowired
	private KunjunganDao dao;
	
	@Override
	public List<KunjunganModel> get() throws Exception {
		return this.dao.get();
	}

	@Override
	public void insert(KunjunganModel model) throws Exception {
		this.dao.insert(model);
	}

	@Override
	public KunjunganModel getById(int id) throws Exception {
		return this.dao.getById(id);
	}

	@Override
	public void update(KunjunganModel model) throws Exception {
		this.dao.update(model);
	}

	@Override
	public void delete(KunjunganModel model) throws Exception {
		this.dao.delete(model);		
	}

}
