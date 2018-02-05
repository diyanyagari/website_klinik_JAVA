package com.xsis.bootcamp.dao;

import java.util.List;

import com.xsis.bootcamp.model.PropinsiModel;

public interface PropinsiDao {
	public List<PropinsiModel> get() throws Exception;
	public void insert(PropinsiModel model) throws Exception;
	public PropinsiModel getById(int id) throws Exception;
	public void update(PropinsiModel model) throws Exception;
	public void delete(PropinsiModel model) throws Exception;
}
