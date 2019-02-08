package com.eteam.web03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.eteam.web03.vo.Sample;

@Mapper
public interface SampleMapper {
	List<Sample> sampleList();
}
