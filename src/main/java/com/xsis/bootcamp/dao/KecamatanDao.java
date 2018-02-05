package com.xsis.bootcamp.dao;

import java.util.List;

import com.xsis.bootcamp.model.KecamatanModel;

public interface KecamatanDao {
	public List<KecamatanModel> get() throws Exception;
	public List<KecamatanModel> getByKotaId(int id) throws Exception;
	public void insert(KecamatanModel model) throws Exception;
	public KecamatanModel getById(int id) throws Exception;
	public void update(KecamatanModel model) throws Exception;
	public void delete(KecamatanModel model) throws Exception;
}
