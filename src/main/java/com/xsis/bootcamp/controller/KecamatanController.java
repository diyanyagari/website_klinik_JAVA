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

import com.xsis.bootcamp.model.KecamatanModel;
import com.xsis.bootcamp.model.KotaModel;
import com.xsis.bootcamp.service.KecamatanService;

@Controller
public class KecamatanController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private KecamatanService service;
	
	@RequestMapping(value="/kecamatan")
	public String index(Model model){
		
		return "kecamatan";
	}
	
	@RequestMapping(value="/kecamatan/list")
	public String list(Model model){
		// membuat object list dari class Kabupaten model
		List<KecamatanModel> items = null;
		
		try {
			// object items diisi data dari method get
			items = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable list kemudian diisi dengan object items
		model.addAttribute("list", items);
		
		return "kecamatan/list";
	}
	
	@RequestMapping(value="/kecamatan/listByKota")
	public String listByKota(Model model, HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("kotaId"));
		// membuat object list dari class Kabupaten model
		List<KecamatanModel> items = null;
		
		try {
			// object items diisi data dari method get
			items = this.service.getByKotaId(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable list kemudian diisi dengan object items
		model.addAttribute("list", items);
		
		return "kecamatan/listByKota";
	}

	
}
