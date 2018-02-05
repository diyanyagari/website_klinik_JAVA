package com.xsis.bootcamp.service;

import java.util.List;

import com.xsis.bootcamp.model.DetailKunjunganModel;

public interface DetailKunjunganService {
	public List<DetailKunjunganModel> get() throws Exception;
	public void insert(DetailKunjunganModel model) throws Exception;
	public DetailKunjunganModel getById(int id) throws Exception;
	public void update(DetailKunjunganModel model) throws Exception;
	public void delete(DetailKunjunganModel model) throws Exception;
}
