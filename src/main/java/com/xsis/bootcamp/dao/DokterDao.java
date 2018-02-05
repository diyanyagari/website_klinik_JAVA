package com.xsis.bootcamp.dao;

import java.util.List;

import com.xsis.bootcamp.model.DokterModel;

public interface DokterDao {
	public List<DokterModel> get() throws Exception;
	public void insert(DokterModel model) throws Exception;
	public DokterModel getById(int id) throws Exception;
	public void update(DokterModel model) throws Exception;
	public void delet(DokterModel model) throws Exception;
}
