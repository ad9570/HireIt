package com.hire.it.service;

import java.util.List;
import java.util.Map;

public interface MainServiceInter {
	
    public List<Map<String,Object>> getQueryAboutCorp(String keyword);
    public List<Map<String,Object>> getQueryAboutJob(String keyword);
    public List<Map<String,Object>> getQueryCorp(String q,int start,int perpage);
    public List<Map<String,Object>> getQueryJob(String q,int start,int perpage);
    public int getTotalCount (String keyword);
    public int getTotalCount2 (String keyword);

    
}
