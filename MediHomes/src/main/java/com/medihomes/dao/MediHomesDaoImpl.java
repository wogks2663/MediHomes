package com.medihomes.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.medihomes.domain.Encyclopedia;
import com.medihomes.domain.HealthInfo;
import com.medihomes.domain.Hospital;
import com.medihomes.domain.Instruments;

@Repository
public class MediHomesDaoImpl implements MediHomesDao {
	
	private final String NAME_SPACE = "com.medihomes.mapper.MediMapper";
	
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 병명으로 병원찾기 리스트 가져오기 
	@Override
	public List<Hospital> hospitalList(
			int startRow, int num, String keyword, String rate) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startRow", startRow);
		params.put("num", num);
		params.put("keyword", keyword);
		params.put("rate", rate);
		System.out.println(keyword);
		return sqlSession.selectList(NAME_SPACE + ".hospitalList", params);
	}
	
	// 의료장비로 병원 찾기 리스트 가져오기
	@Override
	public List<Instruments> instrumentsList(int startRow, int num, String keyword) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startRow", startRow);
		params.put("num", num);
		params.put("keyword", keyword);
		
		return sqlSession.selectList(NAME_SPACE + ".instrumentsList", params);
	}
	
	// 병명으로 병원찾기 리스트 갯수 카운트
	@Override
	public int getHospitalCount(String keyword, String rate) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("keyword", keyword);
		params.put("rate", rate);
		
		return sqlSession.selectOne(NAME_SPACE + ".getHospitalCount", params);
	}
	
	// 의료장비로 병원찾기 리스트 갯수 카운트 
	@Override
	public int getInstrumentsCount(String keyword) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("keyword", keyword);
		
		return sqlSession.selectOne(NAME_SPACE + ".getInstrumentsCount", params);
	}

	// 건강정보 리스트 가져오기 
	@Override
	public List<HealthInfo> healthInfoList(int startRow, int num) {
		
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("startRow", startRow);
		params.put("num", num);
		
		return sqlSession.selectList(NAME_SPACE + ".healthInfoList", params);
	}
	
	// 건강정보 리스트 갯수 카운트
	@Override
	public int getHealthInfoCount() {
	
		return sqlSession.selectOne(NAME_SPACE + ".getHealthInfoCount");
	}
	
	// 증상백과 리스트 가져오기
	@Override
	public List<Encyclopedia> encyclopediaList(int startRow, int num, String keyword) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startRow", startRow);
		params.put("num", num);
		params.put("keyword", keyword);
		System.out.println("keyword : " + keyword);
		return sqlSession.selectList(NAME_SPACE + ".encyclopediaList", params);
	}
	
	// 증상백과 리스트 갯수 카운트
	@Override
	public int getEncyclopediaCount(String keyword) {
	
		return sqlSession.selectOne(NAME_SPACE + ".getEncyclopediaCount", keyword);
	}
}
