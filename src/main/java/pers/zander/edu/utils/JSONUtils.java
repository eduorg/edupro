package pers.zander.edu.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * JSON格式转化工具类
 * @author 赵召
 * Mar 21, 2016 9:59:56 AM
 */
public class JSONUtils {
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> jsonToMap(String jsonstr){
		ObjectMapper om = new ObjectMapper();
		Map<String,String> map = null;
		try {
			map = om.readValue(jsonstr,HashMap.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	} 
	@SuppressWarnings("unchecked")
	public static Map<String,Object> jsonToObjMap(String jsonstr){
		ObjectMapper om = new ObjectMapper();
		Map<String,Object> map = null;
		try {
			map = om.readValue(jsonstr,HashMap.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	} 
	
	public static List<Map<String,String>> jsonToList(String jsonstr){
		ObjectMapper om = new ObjectMapper();
		JavaType javaType = om.getTypeFactory().constructParametricType(ArrayList.class, Map.class);
		List<Map<String,String>> lst = null;
		if(jsonstr==null){
			lst = new ArrayList<Map<String,String>>();
		}else{
			try {
				lst = om.readValue(jsonstr,javaType);
			} catch (JsonParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonMappingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
		return lst;
	}
	
	public static String listToJson(List<Map<String,String>> list){
		ObjectMapper om = new ObjectMapper();
		try {
			return om.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String mapToJson(Map<String,Map<String,Long>> map){
		ObjectMapper om = new ObjectMapper();
		try {
			return om.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String objectToJson(Object obj){
		ObjectMapper om = new ObjectMapper();
		try {
			return om.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	
}
