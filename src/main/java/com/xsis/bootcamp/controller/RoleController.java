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
import com.xsis.bootcamp.service.RoleService;

/**
 * @author sharkbit_
 *
 */

@Controller
public class RoleController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private RoleService service;
	
	@RequestMapping(value="/role")
	public String index(Model model){
		
		return "role";
	}
	
	@RequestMapping(value="/role/list")
	public String list(Model model){
		// membuat object list dari class Propinsi model
		List<RoleModel> items = null;
		
		try {
			// object items diisi data dari method get
			items = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable list kemudian diisi dengan object items
		model.addAttribute("list", items);
		
		return "role/list";
	}
	
	@RequestMapping(value="/role/add")
	public String add(){
		return "role/add";
	}
	
	@RequestMapping(value="/role/save")
	public String save(Model model, @ModelAttribute RoleModel item, HttpServletRequest request){
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
		
		return "role/save";
	}
	
	@RequestMapping(value="/role/edit")
	public String edit(Model model, HttpServletRequest request){
		// menangkap paremeter yang dikirim dari view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// siapkan object Propinsi model
		RoleModel item = null;
		// request ke database
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable item kemudian diisi dengan object item
		model.addAttribute("item", item);
		return "role/edit";
	}
	
	@RequestMapping(value="/role/delete")
	public String delete(Model model, HttpServletRequest request){
		// menangkap paremeter yang dikirim dari view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// siapkan object Propinsi model
		RoleModel item = null;
		// request ke database
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", item);
		return "role/delete";
	}
}
