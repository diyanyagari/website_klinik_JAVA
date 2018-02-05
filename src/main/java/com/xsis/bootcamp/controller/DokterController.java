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

import com.xsis.bootcamp.model.DokterModel;
import com.xsis.bootcamp.model.KecamatanModel;
import com.xsis.bootcamp.model.KotaModel;
import com.xsis.bootcamp.model.PropinsiModel;
import com.xsis.bootcamp.service.DokterService;
import com.xsis.bootcamp.service.KecamatanService;
import com.xsis.bootcamp.service.KotaService;
import com.xsis.bootcamp.service.PropinsiService;

@Controller
public class DokterController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private DokterService service;
	
	@Autowired
	private PropinsiService propinsiService;
	
	@Autowired
	private KotaService kotaService;
	
	@Autowired
	private KecamatanService kecamatanService;
	
	@RequestMapping(value="/dokter")
	public String index(Model model){
		return "dokter";
	}
	
	@RequestMapping(value="/dokter/list")
	public String list(Model model){
		List<DokterModel> items = null;
		
		try {
			items = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		model.addAttribute("list", items);
		return "dokter/list";
	}
	
	@RequestMapping(value="/dokter/add")
	public String add(Model model){
		
		return "dokter/add";
	}
	
	@RequestMapping(value="/dokter/save")
	public String save(Model model, @ModelAttribute DokterModel item, HttpServletRequest request){
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
		
		return "dokter/save";
	}

	@RequestMapping(value="/dokter/edit")
	public String edit(Model model, HttpServletRequest request){
		// menangkap paremeter yang dikirim dari view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// siapkan object Mahasiswa model
		DokterModel item = null;
		// request ke database
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable item kemudian diisi dengan object item
		model.addAttribute("item", item);
		return "dokter/edit";
	}
	
	@RequestMapping(value="/dokter/delete")
	public String delete(Model model, HttpServletRequest request){
		// menangkap paremeter yang dikirim dari view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// siapkan object Mahasiswa model
		DokterModel item = null;
		// request ke database
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", item);
		return "dokter/delete";
	}
}
