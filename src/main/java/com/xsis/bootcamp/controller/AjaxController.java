package com.xsis.bootcamp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.BiayaModel;
import com.xsis.bootcamp.model.DokterModel;
import com.xsis.bootcamp.model.KecamatanModel;
import com.xsis.bootcamp.model.KotaModel;
import com.xsis.bootcamp.model.PasienModel;
import com.xsis.bootcamp.model.PropinsiModel;
import com.xsis.bootcamp.model.RoleModel;
import com.xsis.bootcamp.service.BiayaService;
import com.xsis.bootcamp.service.DokterService;
import com.xsis.bootcamp.service.KecamatanService;
import com.xsis.bootcamp.service.KotaService;
import com.xsis.bootcamp.service.PasienService;
import com.xsis.bootcamp.service.PropinsiService;
import com.xsis.bootcamp.service.RoleService;

@Controller
public class AjaxController {
	
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private PropinsiService provService; 
	
	@Autowired
	private KotaService kotaService;
	
	@Autowired
	private KecamatanService kecService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private DokterService dokterService;
	
	@Autowired
	private PasienService pasienService;
	
	@Autowired
	private BiayaService biayaService;
	
	@RequestMapping(value="/ajax/getBiaya")
	public String getBiaya(Model model){
		List<BiayaModel> result = null;
		
		try {
			result = biayaService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		model.addAttribute("result", result);
		
		return "ajax/getBiaya";		
	}
	
	@RequestMapping(value="/ajax/getPasien")
	public String getPasien(Model model){
		List<PasienModel> result = null;
		
		try {
			result = pasienService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		model.addAttribute("result", result);
		
		return "ajax/getPasien";		
	}
	
	@RequestMapping(value="/ajax/getDokter")
	public String getDokter(Model model){
		List<DokterModel> result = null;
		
		try {
			result = dokterService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		model.addAttribute("result", result);
		
		return "ajax/getDokter";		
	}
	
	@RequestMapping(value="/ajax/getRole")
	public String getRole(Model model){
		List<RoleModel> result = null;
		
		try {
			result = roleService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		model.addAttribute("result", result);
		
		return "ajax/getRole";		
	}
	
	@RequestMapping(value="/ajax/getProvinsi")
	public String getProvinsi(Model model){
		List<PropinsiModel> result = null;
		
		try {
			result = provService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		model.addAttribute("result", result);
		
		return "ajax/getProvinsi";		
	}
	
	@RequestMapping(value="/ajax/getKota")
	public String getKota(Model model, HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("propinsiId"));
		// membuat object list dari class Kabupaten model
		List<KotaModel> items = null;
		
		try {
			// object items diisi data dari method get
			items = this.kotaService.getByPropinsiId(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable list kemudian diisi dengan object items
		model.addAttribute("list", items);
		
		return "ajax/getKota";		
	}

	@RequestMapping(value="/ajax/getKecamatan")
	public String getKecamatan(Model model, HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("kotaId"));
		// membuat object list dari class Kabupaten model
		List<KecamatanModel> items = null;
		
		try {
			// object items diisi data dari method get
			items = this.kecService.getByKotaId(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable list kemudian diisi dengan object items
		model.addAttribute("list", items);
		
		return "ajax/getKecamatan";		
	}
}
