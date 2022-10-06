package com.hire.it.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PageDto {

	private List<Object> list;
	private ArrayList<Integer> parr;
	private int totalPage;
	private int totalCount;
	private int startPage;
	private int endPage;
	private int no;

}
