package com.hire.it.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hire.it.dto.AlarmDto;
import com.hire.it.dto.MemberDto;
import com.hire.it.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/statistics")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public Map<String, Integer> getCount() {
		Map<String, Integer> map = new HashMap<>();
		
		List<Integer> list = new ArrayList<>();
		list = adminService.getMemberCount();
		
		map.put("indiv", list.get(0));
		map.put("corp", list.get(1));
		map.put("jobPosting", adminService.getJobPostingCount());
		map.put("apply", adminService.getApplyCount());
		map.put("rate", adminService.getEmpRate());
		
		return map;
	}
	
	@GetMapping("/userList")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public List<MemberDto> userList() {
		return adminService.getMemberList();
	}
	
	@GetMapping("/corpApply")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public List<AlarmDto> corpApply() {
		return adminService.getCorpApplication();
	}
	
}
