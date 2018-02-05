package com.xsis.bootcamp.service;

import java.util.List;

import com.xsis.bootcamp.model.ObatModel;

public interface ObatService {
	public List<ObatModel> get() throws Exception;
	public void insert(ObatModel model) throws Exception;
	public ObatModel getById(int id) throws Exception;
	public void update(ObatModel model) throws Exception;
	public void delete(ObatModel model) throws Exception;
}
