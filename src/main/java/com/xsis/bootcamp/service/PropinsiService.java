package com.xsis.bootcamp.service;

import java.util.List;

import com.xsis.bootcamp.model.PropinsiModel;

public interface PropinsiService {
	public List<PropinsiModel> get() throws Exception;
	public void insert(PropinsiModel model) throws Exception;
	public PropinsiModel getById(int id) throws Exception;
	public void update(PropinsiModel model) throws Exception;
	public void delete(PropinsiModel model) throws Exception;
}
