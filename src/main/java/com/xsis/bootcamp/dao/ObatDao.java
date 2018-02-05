package com.xsis.bootcamp.dao;

import java.util.List;

import com.xsis.bootcamp.model.ObatModel;

public interface ObatDao {
	public List<ObatModel> get() throws Exception;
	public void insert(ObatModel model) throws Exception;
	public ObatModel getById(int id) throws Exception;
	public void update(ObatModel model) throws Exception;
	public void delete(ObatModel model) throws Exception;
}
