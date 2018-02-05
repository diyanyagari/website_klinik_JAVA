/**
 * 
 */
package com.xsis.bootcamp.dao;

import java.util.List;

import com.xsis.bootcamp.model.UserModel;

/**
 * @author sharkbit_
 *
 */
public interface UserDao {
	public List<UserModel> get() throws Exception;
	public void Insert (UserModel model) throws Exception;
	public UserModel getById(int id) throws Exception;
	public void update (UserModel model) throws Exception;
	public void delete (UserModel model) throws Exception;
}
