package com.xsis.bootcamp.service;

import java.util.List;

import com.xsis.bootcamp.model.DokterModel;

public interface DokterService {
	public List<DokterModel> get() throws Exception;
	public void insert(DokterModel model) throws Exception;
	public DokterModel getById(int id) throws Exception;
	public void update(DokterModel model) throws Exception;
	public void delete(DokterModel model) throws Exception;
}
