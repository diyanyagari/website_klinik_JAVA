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

import com.xsis.bootcamp.model.KecamatanModel;
import com.xsis.bootcamp.model.KotaModel;
import com.xsis.bootcamp.model.PasienModel;
import com.xsis.bootcamp.model.PropinsiModel;
import com.xsis.bootcamp.service.KecamatanService;
import com.xsis.bootcamp.service.KotaService;
import com.xsis.bootcamp.service.PasienService;
import com.xsis.bootcamp.service.PropinsiService;



@Controller
public class PasienController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private PasienService service;
	
	@Autowired
	private PropinsiService propService;
	
	@Autowired
	private KotaService kotaService;
	
	@Autowired
	private KecamatanService kecamatanService;
	
	
	
	@RequestMapping(value="/pasien")
	public String index(Model model){
		
		return "pasien";
	}
	
	@RequestMapping(value="/pasien/list")
	public String list(Model model){
		// membuat object list dari class Mahasiswa model
		List<PasienModel> items = null;
		List<PropinsiModel> propinsi = null;
		List<KotaModel> kota = null;
		List<KecamatanModel> kecamatan = null;
		
		try {
			// object items diisi data dari method get
			items = this.service.get();
			propinsi = this.propService.get();
			kota = this.kotaService.get();
			kecamatan = this.kecamatanService.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable list kemudian diisi dengan object items
		model.addAttribute("kecamatan", kecamatan);
		model.addAttribute("kota", kota);
		model.addAttribute("propinsi", propinsi);
		model.addAttribute("list", items);
		
		return "pasien/list";
	}
	
	@RequestMapping(value="/pasien/add")
	public String add(Model model){
		List<PropinsiModel> listPropinsi = null;
		
		
		try {
			listPropinsi = this.propService.get();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		model.addAttribute("listPropinsi", listPropinsi);
		
		
		return "pasien/add";
	}
	
	@RequestMapping(value="/pasien/save")
	public String save(Model model, @ModelAttribute PasienModel item, HttpServletRequest request){
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
		
		return "pasien/save";
	}
	
	@RequestMapping(value="/pasien/edit")
	public String edit(Model model, HttpServletRequest request){
		// menangkap paremeter yang dikirim dari view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// siapkan object Mahasiswa model
		PasienModel item = null;
		// request ke database
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable item kemudian diisi dengan object item
		model.addAttribute("item", item);
		return "pasien/edit";
	}
	
	@RequestMapping(value="/pasien/delete")
	public String delete(Model model, HttpServletRequest request){
		// menangkap paremeter yang dikirim dari view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// siapkan object Mahasiswa model
		PasienModel item = null;
		// request ke database
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", item);
		return "pasien/delete";
	}
}
