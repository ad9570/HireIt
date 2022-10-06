package com.hire.it.util;

import java.util.ArrayList;

import com.hire.it.dto.PageDto;

public class PageHandler {

	public PageDto pageHandler(int totalCount, int perPage, int perBlock, int currentPage) {
		int totalPage;
		int startNum;
		int startPage;
		int endPage;
		int no;
		ArrayList<Integer> parr = new ArrayList<>();
		
		PageDto dto = new PageDto();
		
		startNum = (currentPage - 1) * perPage;
		totalPage = (int)Math.ceil((double)totalCount / perPage);
		no = totalCount - startNum;
		
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		endPage = totalPage < endPage ? totalPage : endPage;
		
		for(int i = startPage; i <= endPage; i++)
			parr.add(i);
		
		dto.setParr(parr);
		dto.setTotalPage(totalPage);
		dto.setTotalCount(totalCount);
		dto.setStartPage(startPage);
		dto.setEndPage(endPage);
		dto.setNo(no);
		
		return dto;
	}
	
}
