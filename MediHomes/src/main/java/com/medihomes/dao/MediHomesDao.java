package com.medihomes.dao;

import java.util.List;

import com.medihomes.domain.Encyclopedia;
import com.medihomes.domain.HealthInfo;
import com.medihomes.domain.Hospital;
import com.medihomes.domain.Instruments;

public interface MediHomesDao {
	
	// 병명으로 병원찾기 리스트 가져오기 
	public abstract List<Hospital> hospitalList(
			int startRow, int num, String keyword, String rate);
	
	// 기구로 병원 찾기 리스트 가져오기
	public abstract List<Instruments> instrumentsList(
			int startRow, int num, String keyword);
	
	// 병명으로 병원찾기 리스트 갯수 카운트
	public abstract int getHospitalCount(String keyword, String rate);
	
	// 의료장비로 병원찾기 리스트 갯수 카운트 
	public abstract int getInstrumentsCount(String keyword);
	
	// 건강정보 리스트 가져오기 
	public abstract List<HealthInfo> healthInfoList(int startRow, int num);
	
	// 건강정보 리스트 갯수 카운트 
	public abstract int getHealthInfoCount();
	
	// 증상백과 리스트 가져오기 	
	public abstract List<Encyclopedia> encyclopediaList(int startRow, int num, String keyword);
	
	// 증상백과 리스트 갯수 카운트
	public abstract int getEncyclopediaCount(String keyword);
}
