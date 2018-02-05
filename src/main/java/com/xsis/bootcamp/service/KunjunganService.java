package com.xsis.bootcamp.service;

import java.util.List;

import com.xsis.bootcamp.model.KunjunganModel;

public interface KunjunganService {
	public List<KunjunganModel> get() throws Exception;
	public void insert(KunjunganModel model) throws Exception;
	public KunjunganModel getById(int id) throws Exception;
	public void update(KunjunganModel model) throws Exception;
	public void delete(KunjunganModel model) throws Exception;
}
