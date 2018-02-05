package com.xsis.bootcamp.service;

import java.util.List;

import com.xsis.bootcamp.model.PenyakitModel;

public interface PenyakitService {
	public List<PenyakitModel> get() throws Exception;
	public void insert(PenyakitModel model) throws Exception;
	public PenyakitModel getById(int id) throws Exception;
	public void update(PenyakitModel model) throws Exception;
	public void delete(PenyakitModel model) throws Exception;
}
