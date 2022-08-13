package com.hire.it.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hire.it.dto.InsContentDto;

@Mapper
public interface InsContentMapper {
	
    public List<InsContentDto> getInsContents(int tag);
    
}
