package com.hire.it.util;

import java.util.Date;

public class FileUtil {
	
	public String changeFileName(String fileName)
	{
		int dot = fileName.lastIndexOf('.');
		String ext = fileName.substring(dot, fileName.length()); //.부터 끝까지 확장자 추출
		String file = fileName.substring(0,dot); //dot이전 추출
		
		Date date = new Date();
		int y = date.getYear()+1900;
		int m = date.getMonth()+1;
		int d = date.getDate();
		int hh = date.getHours();
		int mm = date.getMinutes();
		int ss = date.getSeconds();
		String renameFile = "" + y + (m<10?"0"+m:m) + (d<10?"0"+d:d) + (hh<10?"0"+hh:hh)
							+ (mm<10?"0"+mm:mm) + (ss<10?"0"+ss:ss) + ext;  
		return renameFile;
	}

}
