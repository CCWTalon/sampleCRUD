package com.eteam.web03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eteam.web03.vo.Sample;

@Mapper
public interface SampleMapper {
	// 1. addSample
	int insertSample(String sampleName);
	
	// 2. sampleList
	List<Sample> selectSampleList();
	
	// 3. deleteSample
	int deleteSample(int sampleId);
	
	// 4.selectSampleOne
	Sample selectSampleOne(int sampleId);
	
	// 5.updateSample
	int updateSample(String sampleName);
}
