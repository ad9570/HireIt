package com.hire.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hire.it.dto.AlarmDto;
import com.hire.it.dto.MemberDto;
import com.hire.it.mapper.AdminMapper;

@Service
public class AdminService implements AdminServiceInter {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public List<Integer> getMemberCount() {
		return adminMapper.getMemberCount();
	}

	@Override
	public int getJobPostingCount() {
		return adminMapper.getJobPostingCount();
	}

	@Override
	public int getApplyCount() {
		return adminMapper.getApplyCount();
	}

	@Override
	public int getEmpRate() {
		return (int)Math.round(adminMapper.getEmpRate() * 100);
	}

	@Override
	public List<MemberDto> getMemberList() {
		return adminMapper.getMemberList();
	}

	@Override
	public List<AlarmDto> getCorpApplication() {
		return adminMapper.getCorpApplication();
	}

	@Override
	public void applyHandle(int num, int idx) {
		adminMapper.applyHandle(num);
		adminMapper.changeRole(idx);
		adminMapper.changeAuth(idx);
	}

}
