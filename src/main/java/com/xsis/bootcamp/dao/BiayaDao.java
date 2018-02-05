package com.xsis.bootcamp.dao;

import java.util.List;

import com.xsis.bootcamp.model.BiayaModel;

public interface BiayaDao {
	public List<BiayaModel> get() throws Exception;
	public void insert(BiayaModel model) throws Exception;
	public BiayaModel getById(int id) throws Exception;
	public void update(BiayaModel model) throws Exception;
	public void delete(BiayaModel model) throws Exception;
}
