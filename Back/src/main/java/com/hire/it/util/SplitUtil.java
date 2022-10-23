package com.hire.it.util;

import java.util.Map;

public class SplitUtil {

	public void clickedType(Map<String, Object> map, String[] arr, int num, String buttonType) {
		for (int i=0; i<arr.length; i++) {
			String key = buttonType+(i+1);
			map.put(key, '%'+arr[i]+'%');
		}
		for (int i=arr.length; i<num; i++) {
			String key = buttonType+(i+1);
			map.put(key, "");
		}
	}
	
}
