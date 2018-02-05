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

import com.xsis.bootcamp.model.ObatModel;
import com.xsis.bootcamp.service.ObatService;

@Controller
public class ObatController {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private ObatService service;
	
	@RequestMapping(value="/obat")
	public String index(Model model){
		
		return "obat";
	}
	
	@RequestMapping(value="/obat/list")
	public String list(Model model){
		// membuat object list dari class Obat model
		List<ObatModel> items = null;
		
		try {
			// object items diisi data dari method get
			items = this.service.get();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable list kemudian diisi dengan object items
		model.addAttribute("list", items);
		
		return "obat/list";
	}
	
	@RequestMapping(value="/obat/add")
	public String add(){
		return "obat/add";
	}
	
	@RequestMapping(value="/obat/save")
	public String save(Model model, @ModelAttribute ObatModel item, HttpServletRequest request){
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
		
		return "obat/save";
	}
	
	@RequestMapping(value="/obat/edit")
	public String edit(Model model, HttpServletRequest request){
		// menangkap paremeter yang dikirim dari view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// siapkan object Obat model
		ObatModel item = null;
		// request ke database
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		// datanya kita kirim ke view, 
		// kita buat variable item kemudian diisi dengan object item
		model.addAttribute("item", item);
		return "obat/edit";
	}
	
	@RequestMapping(value="/obat/delete")
	public String delete(Model model, HttpServletRequest request){
		// menangkap paremeter yang dikirim dari view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// siapkan object Obat model
		ObatModel item = null;
		// request ke database
		try {
			item = this.service.getById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		model.addAttribute("item", item);
		return "obat/delete";
	}
}
