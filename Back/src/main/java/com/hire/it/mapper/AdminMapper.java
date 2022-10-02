package com.hire.it.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hire.it.dto.AlarmDto;
import com.hire.it.dto.MemberDto;

@Mapper
public interface AdminMapper {

	public List<Integer> getMemberCount();
	public int getJobPostingCount();
	public int getApplyCount();
	public double getEmpRate();
	public List<MemberDto> getMemberList();
	public List<AlarmDto> getCorpApplication();
	public void applyHandle(int num);
	public void changeRole(int idx);
	public void changeAuth(int idx);
	
}
