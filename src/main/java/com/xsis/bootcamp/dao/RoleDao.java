/**
 * 
 */
package com.xsis.bootcamp.dao;

import java.util.List;

import com.xsis.bootcamp.model.RoleModel;

/**
 * @author sharkbit_
 *
 */
public interface RoleDao {
	public List<RoleModel> get() throws Exception;
	public void insert(RoleModel model) throws Exception;
	public RoleModel getById(int id) throws Exception;
	public void update (RoleModel model) throws Exception;
	public void delete (RoleModel model) throws Exception;
}
