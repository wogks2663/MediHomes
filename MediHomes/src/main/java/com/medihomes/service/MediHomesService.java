package com.medihomes.service;

import java.util.Map;

public interface MediHomesService {
	
	// 질병으로 병원 찾기 리스트 가져오기
	public abstract Map<String, Object> hospitalList(
			int pageNum, String keyword, String rate);
	
	// 의료장비로 병원 찾기 리스트 가져오기
	public abstract Map<String, Object> instrumentsList(
			int pageNum, String keyword);
	
	// 건강정보 리스트 가져오기
	public abstract Map<String, Object> healthInfoList(int pageNum);
	
	// 증상백과 리스트 가져오기
	public abstract Map<String, Object> mediEncyclopediaList(int pageNum, String keyword);

}
