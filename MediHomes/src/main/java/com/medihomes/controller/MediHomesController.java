package com.medihomes.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.medihomes.service.MediHomesService;

@Controller
public class MediHomesController {
	
	@Autowired
	private MediHomesService service;
	
	public void setMediHomesService(MediHomesService service) {
		this.service = service;
	}
	
	// 메인 페이지 이동
	@RequestMapping(value={"/mediMain"}, method=RequestMethod.GET)
	public String mediHomesMain() {	
		return "mediMain";
	}
	
	// 자기 진단 테스트
	@RequestMapping(value={"/mediSelfTest"}, method=RequestMethod.GET)
	public String mediHomesSelfTest() {	
		return "mediSelfTest";
	}
	
	// 질병으로 병원찾기
	@RequestMapping(value= {"/mediDisease"}, method=RequestMethod.GET)
	public String mediHomesDesease(Model model,
				@RequestParam(value="pageNum", required=false, 
				defaultValue="1") int pageNum,
				@RequestParam(value="keyword", required=false,
				defaultValue="null") String keyword,
				@RequestParam(value="rate", required=false,
				defaultValue="null") String rate) {
				
				Map<String, Object> modelMap = 
						service.hospitalList(pageNum, keyword, rate);
		
				model.addAllAttributes(modelMap);
				model.addAttribute("keyword", keyword);
				model.addAttribute("rate", rate);
				System.out.println("modelmap : " + modelMap );
			return "mediDisease";
	}
	
	// 의료장비로 병원 찾기
	@RequestMapping(value= {"/mediInstruments"}, method=RequestMethod.GET)
	public String mediHomesInstruments(Model model, 
			@RequestParam(value="pageNum", required=false, 
			defaultValue="1") int pageNum,
			@RequestParam(value="keyword", required=false,
			defaultValue="null") String keyword) {
		
			Map<String, Object> modelMap1 = 
				service.instrumentsList(pageNum, keyword);

		model.addAllAttributes(modelMap1);
		model.addAttribute("keyword", keyword);
		return "mediInstruments";
	}
	
	// 건강정보
	@RequestMapping(value= {"/mediHealthInfo"}, method=RequestMethod.GET)
	public String mediHomesHealthInfo(Model model,
			@RequestParam(value="pageNum", required=false,
			defaultValue="1") int pageNum) {
		
		Map<String, Object> modelMap1 = service.healthInfoList(pageNum);
		
		model.addAllAttributes(modelMap1);

		return "mediHealthInfo";
	}
	
	// 증상백과
	@RequestMapping(value= {"/mediEncyclopedia"}, method=RequestMethod.GET)
	public String mediHomesEncyclopedia(Model model,
			@RequestParam(value="pageNum", required=false,
			defaultValue="1") int pageNum,
			@RequestParam(value="keyword", required=false,
			defaultValue="null") String keyword) {
		
		Map<String, Object> modelMap2 = service.mediEncyclopediaList(pageNum, keyword);
		
		model.addAllAttributes(modelMap2);

		return "mediEncyclopedia";
	}
}
