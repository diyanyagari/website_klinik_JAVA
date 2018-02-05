package com.xsis.bootcamp.dao;

import java.util.List;

import com.xsis.bootcamp.model.KunjunganModel;

public interface KunjunganDao {
	public List<KunjunganModel> get() throws Exception;
	public void insert(KunjunganModel model) throws Exception;
	public KunjunganModel getById(int id) throws Exception;
	public void update(KunjunganModel model) throws Exception;
	public void delete(KunjunganModel model) throws Exception;
}
