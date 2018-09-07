package com.encore.persistence;

import java.util.Map;

public interface PointDAO {
	
   public boolean updatePoint(String userid,int point)throws Exception;
   //public void updatePoint(Map<String, Object> map)throws Exception;
   
}