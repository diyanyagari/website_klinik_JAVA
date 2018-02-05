/**
 * 
 */
package com.xsis.bootcamp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.RoleModel;
import com.xsis.bootcamp.model.UserModel;
import com.xsis.bootcamp.service.RoleService;
import com.xsis.bootcamp.service.UserService;

/**
 * @author sharkbit_
 *
 */
@Controller
public class UserController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private UserService service;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/user")
	public String index(Model model){
		
		return "user";
	}
	
	@RequestMapping(value="/user/list")
	public String list(Model model){
		// membuat object list dari class Propinsi model
		List<UserModel> items = null;
		List<RoleModel> role = null;
		
		try {
			// object items diisi data dari method get
			role = this.roleService.get();
			items = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		// datanya kita kirim ke view, 
		// kita buat variable list kemudian diisi dengan object items
		model.addAttribute("role", role);
		model.addAttribute("list", items);
		return "user/list";
	}
	
	@RequestMapping(value="/user/add")
	public String add(){
		return "user/add";
	}
	
	@RequestMapping(value="/user/save")
	public String save(Model model, @ModelAttribute UserModel item, HttpServletRequest request){
		String proses = request.getParameter("proses");
		String result ="";
		// proses input ke database
		try {
			if(proses.equals("insert")){
				this.service.insert(item);
			}else if(proses.equals("update")){
				this.service.update(item);
			}else if(proses.equals("delete")){
				this.service.delete(item);
			}
			
			result="berhasil";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result ="gagal";
		}
		model.addAttribute("result",result);
		
		return "user/save";
	}
	
	@RequestMapping(value="/user/edit")
	public String edit(Model model, HttpServletRequest request){
		// menangkap paremeter yang dikirim dari view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// siapkan object Propinsi model
		UserModel item = null;
		
		// request ke database
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable item kemudian diisi dengan object item
		model.addAttribute("item", item);
		return "user/edit";
	}
	
	@RequestMapping(value="/user/delete")
	public String delete(Model model, HttpServletRequest request){
		// menangkap paremeter yang dikirim dari view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// siapkan object Propinsi model
		UserModel item = null;
		// request ke database
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", item);
		return "user/delete";
	}
}
