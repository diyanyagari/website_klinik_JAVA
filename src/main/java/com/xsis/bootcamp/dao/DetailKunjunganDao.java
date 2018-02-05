package com.xsis.bootcamp.dao;

import java.util.List;

import com.xsis.bootcamp.model.DetailKunjunganModel;

public interface DetailKunjunganDao {
	public List<DetailKunjunganModel> get() throws Exception;
	public void insert(DetailKunjunganModel model) throws Exception;
	public DetailKunjunganModel getById(int id) throws Exception;
	public void update(DetailKunjunganModel model) throws Exception;
	public void delete(DetailKunjunganModel model) throws Exception;
}
