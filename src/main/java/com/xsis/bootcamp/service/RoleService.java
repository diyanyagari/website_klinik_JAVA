/**
 * 
 */
package com.xsis.bootcamp.service;

import java.util.List;

import com.xsis.bootcamp.model.RoleModel;

/**
 * @author sharkbit_
 *
 */
public interface RoleService {
	public List<RoleModel> get() throws Exception;
	public void insert (RoleModel model) throws Exception;
	public RoleModel getById(int id) throws Exception;
	public void update (RoleModel model) throws Exception;
	public void delete (RoleModel model) throws Exception;
}
