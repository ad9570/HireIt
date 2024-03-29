package com.hire.it.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hire.it.dto.MemberDto;
import com.hire.it.dto.ResumeDto;
import com.hire.it.dto.ResumeSaveDto;

@Mapper
public interface ResumeMapper {
	public void insertResume(ResumeDto dto);
	public MemberDto resumeUserInfo(String username);
	public ResumeSaveDto resumeSaveDetail(Map<String, Object> map);
	public void saveResume(ResumeSaveDto dto);
	public ResumeSaveDto getIdx(String username);
	public void deleteResume(int resume_idx);
	public void updateSaveResume(ResumeSaveDto dto);
	public ResumeDto resumeDetail(int resume_idx);
	public ResumeDto getDetailIdx(String username);
	public void updateResume(ResumeDto dto);
	public List<ResumeDto> resumeList(String username);
}
