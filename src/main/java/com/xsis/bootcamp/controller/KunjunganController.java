package com.xsis.bootcamp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.bootcamp.model.PasienModel;
import com.xsis.bootcamp.model.PropinsiModel;
import com.xsis.bootcamp.service.DetailKunjunganService;
import com.xsis.bootcamp.service.KunjunganService;
import com.xsis.bootcamp.service.PasienService;

@Controller
public class KunjunganController {
	@Autowired
	private KunjunganService kunjunganService;
	
	@Autowired 
	private DetailKunjunganService detailService;
	
	@Autowired
	private PasienService pasienService;
	
	Log log = LogFactory.getLog(getClass());
	
	@RequestMapping(value="/kunjungan")
	public String Home(Model model){
		return "kunjungan";
	}
	
	@RequestMapping(value="/kunjungan/add")
	public String add(){
		return "kunjungan/add";
	}
	
	@RequestMapping(value="/kunjungan/pasienSearch")
	public String pasienSearch(Model model, HttpServletRequest request){
		// membuat object list dari class Mahasiswa model
				List<PasienModel> items = null;
				
				try {
					// object items diisi data dari method get
					items = this.pasienService.get();
				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
				
				// datanya kita kirim ke view, 
				// kita buat variable list kemudian diisi dengan object items
				model.addAttribute("list", items);
				
		return "kunjungan/listPasien";
	}
	
}
