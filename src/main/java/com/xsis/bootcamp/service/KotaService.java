package com.xsis.bootcamp.service;

import java.util.List;

import com.xsis.bootcamp.model.KotaModel;

public interface KotaService {
	public List<KotaModel> get() throws Exception;
	public List<KotaModel> getByPropinsiId(int id) throws Exception;
	public void insert(KotaModel model) throws Exception;
	public KotaModel getById(int id) throws Exception;
	public void update(KotaModel model) throws Exception;
	public void delete(KotaModel model) throws Exception;
}
