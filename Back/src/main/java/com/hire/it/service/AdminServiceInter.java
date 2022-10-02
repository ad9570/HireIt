package com.hire.it.service;

import java.util.List;

import com.hire.it.dto.AlarmDto;
import com.hire.it.dto.MemberDto;

public interface AdminServiceInter {

	public List<Integer> getMemberCount();
	public int getJobPostingCount();
	public int getApplyCount();
	public int getEmpRate();
	public List<MemberDto> getMemberList();
	public List<AlarmDto> getCorpApplication();
	public void applyHandle(int num, int idx);

}
