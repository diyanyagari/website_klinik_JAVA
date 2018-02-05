package com.xsis.bootcamp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.KotaModel;
import com.xsis.bootcamp.service.KotaService;

@Controller
public class KotaController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private KotaService service;
	
	@RequestMapping(value="/kota")
	public String index(Model model){
		
		return "kota";
	}
	
	@RequestMapping(value="/kota/list")
	public String list(Model model){
		// membuat object list dari class Kabupaten model
		List<KotaModel> items = null;
		
		try {
			// object items diisi data dari method get
			items = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable list kemudian diisi dengan object items
		model.addAttribute("list", items);
		
		return "kota/list";
	}
	
	@RequestMapping(value="/kota/listByPropinsi")
	public String listByPropinsi(Model model, HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("propinsiId"));
		// membuat object list dari class Kabupaten model
		List<KotaModel> items = null;
		
		try {
			// object items diisi data dari method get
			items = this.service.getByPropinsiId(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable list kemudian diisi dengan object items
		model.addAttribute("list", items);
		
		return "kota/listByPropinsi";
	}
	
}
