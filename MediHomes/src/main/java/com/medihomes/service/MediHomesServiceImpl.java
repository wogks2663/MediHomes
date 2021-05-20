package com.medihomes.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medihomes.dao.MediHomesDao;
import com.medihomes.domain.Encyclopedia;
import com.medihomes.domain.HealthInfo;
import com.medihomes.domain.Hospital;
import com.medihomes.domain.Instruments;

@Service
public class MediHomesServiceImpl implements MediHomesService {
	
	private static final int PAGE_SIZE = 10;
	
	private static final int PAGE_GROUP = 10;
	
	@Autowired
	private MediHomesDao mediHomesDao;	
	
	public void setMediHomesDao(MediHomesDao mediHomesDao) {
		this.mediHomesDao = mediHomesDao;
	}
	
	// 질병으로 병원 찾기 리스트 가져오기
	@Override
	public Map<String, Object> hospitalList(int pageNum, String keyword, String rate) {
		
		int currentPage = pageNum;  //1
		int startRow =  (currentPage - 1) * PAGE_SIZE ; // 1, 11, 21 , 31, 40
		int listCount = 0;
		System.out.println("currentPage :" + currentPage);
		listCount = mediHomesDao.getHospitalCount(keyword, rate);
		
		
		List<Hospital> pList = mediHomesDao.hospitalList(startRow, PAGE_SIZE, keyword, rate);
		
		
		int pageCount = 
				listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
					- (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		System.out.println("startRow :" + startRow);
		int endPage = startPage + PAGE_GROUP - 1;
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
			modelMap.put("pList", pList);
			modelMap.put("pageCount", pageCount);
			modelMap.put("startPage", startPage);
			modelMap.put("endPage", endPage);
			modelMap.put("currentPage", currentPage);
			modelMap.put("listCount", listCount);
			modelMap.put("pageGroup", PAGE_GROUP);
			modelMap.put("rate", rate);
			
		return modelMap;
	}
	
	// 의료장비로 병원 찾기 리스트 가져오기
	@Override
	public Map<String, Object> instrumentsList(int pageNum, String keyword) {
		
		int currentPage = pageNum;  //1
		int startRow =  (currentPage - 1) * PAGE_SIZE ; // 1, 11, 21 , 31, 40
		int listCount = 0;
		System.out.println("currentPage :" + currentPage);
		listCount = mediHomesDao.getInstrumentsCount(keyword);
		
		List<Instruments> iList = mediHomesDao.instrumentsList(startRow, PAGE_SIZE, keyword);
		
		
		int pageCount = 
				listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
					- (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		System.out.println("startRow :" + startRow);
		int endPage = startPage + PAGE_GROUP - 1;
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		Map<String, Object> modelMap1 = new HashMap<String, Object>();
		
			modelMap1.put("iList", iList);
			modelMap1.put("pageCount", pageCount);
			modelMap1.put("startPage", startPage);
			modelMap1.put("endPage", endPage);
			modelMap1.put("currentPage", currentPage);
			modelMap1.put("listCount", listCount);
			modelMap1.put("pageGroup", PAGE_GROUP);
			
		return modelMap1;
	}
	
	// 건강정보 리스트 가져오기
	@Override
	public Map<String, Object> healthInfoList(int pageNum) {
		
		int currentPage = pageNum;
		int startRow = (currentPage - 1) * PAGE_SIZE;
		int listCount = mediHomesDao.getHealthInfoCount();
		System.out.println("startRow :" + currentPage);
		List<HealthInfo> healthInfoList = mediHomesDao.healthInfoList(startRow, PAGE_SIZE);
		
		int pageCount = 
				listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
				- (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		
		int endPage = startPage + PAGE_GROUP - 1;
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		Map<String, Object> modelMap1 = new HashMap<String, Object>();
		
		modelMap1.put("healthInfoList", healthInfoList);
		modelMap1.put("pageCount", pageCount);
		modelMap1.put("startPage", startPage);
		modelMap1.put("endPage", endPage);
		modelMap1.put("currentPage", currentPage);
		modelMap1.put("listCount", listCount);
		modelMap1.put("pageGroup", PAGE_GROUP);
		
		return modelMap1;
	}
	
	// 증상백과 리스트 가져오기
	@Override
	public Map<String, Object> mediEncyclopediaList(int pageNum, String keyword) {
		
		int currentPage = pageNum;
		int startRow = (currentPage - 1) * PAGE_SIZE;
		int listCount = mediHomesDao.getEncyclopediaCount(keyword);
		
		List<Encyclopedia> encyclopediaList = mediHomesDao.encyclopediaList(startRow, PAGE_SIZE, keyword);
		
		int pageCount = 
				listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
				- (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		
		int endPage = startPage + PAGE_GROUP - 1;
		
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		Map<String, Object> modelMap2 = new HashMap<String, Object>();
		
		modelMap2.put("encyclopediaList", encyclopediaList);
		modelMap2.put("pageCount", pageCount);
		modelMap2.put("startPage", startPage);
		modelMap2.put("endPage", endPage);
		modelMap2.put("currentPage", currentPage);
		modelMap2.put("listCount", listCount);
		modelMap2.put("pageGroup", PAGE_GROUP);
		modelMap2.put("keyword", keyword);
		
		return modelMap2;
		
	}

}