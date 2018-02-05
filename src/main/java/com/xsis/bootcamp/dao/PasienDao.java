package com.xsis.bootcamp.dao;

import java.util.List;

import com.xsis.bootcamp.model.PasienModel;

public interface PasienDao {
	public List<PasienModel> get() throws Exception;
	public void insert(PasienModel model) throws Exception;
	public PasienModel getById(int id) throws Exception;
	public void update(PasienModel model) throws Exception;
	public void delete(PasienModel model) throws Exception;
}
