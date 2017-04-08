package pers.zander.edu.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据手机号获取省份
 * @author 赵召
 * Jan 12, 2016 4:01:17 PM
 */
public class PhoneToProvince {

	public static void getProvince(){
//		String logPath = "D://tel/uas";
		String resultPath = "D://tel/result/result2.txt";
		String phonePath = "D://tel/user-code.txt";
    	FileReader reader;
    	FileWriter writer ;
    	BufferedReader br;
    	BufferedWriter bw;
    	Map<String, String> map = new HashMap<String, String>() ;
    	try {
    		reader = new FileReader(phonePath);
    		br = new BufferedReader(reader);
    		
    		String str = null;
    		
    		Long b = System.currentTimeMillis();
    		System.out.println("read phone begin>>>"+new Date());
    		while((str = br.readLine()) != null) {
    			map.put(str, "1");
    		}
    		Long e = System.currentTimeMillis();
    		System.out.println("read phone end>>>"+new Date());
    		System.out.println("read phone needTime>>>"+(e-b)/1000+"s");
    		System.out.println("phone map size>>>"+map.size());
    		br.close();
    		reader.close();
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	try {
			writer =  new FileWriter(resultPath);
			bw = new BufferedWriter(writer);
			int index = 1 ;
			for (Map.Entry<String, String> entry : map.entrySet()) {
				String url = "http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="+entry.getKey();
				String result = HttpClientUtils.getInstance().getStrResponseBodyAsStream(url, 3000, 3000, "GBK");
				result = result.replaceAll("__GetZoneResult_ = ", "");
				result = result.replaceAll("[\r][\n]", "");
				result = result.replaceAll(" ", "");
				result = result.replaceAll("	", "");
				result = result.replaceAll("\\{", "\\{'");
				result = result.replaceAll(",", ",'");
				result = result.replaceAll(":", "':");
				result = result.replaceAll("'", "\"");
				Map<String,Object> pmap = JSONUtils.jsonToObjMap(result);
				String s = entry.getKey()+"|"+pmap.get("province");
				System.out.println(index+">>>>>"+s);
				index++;
				bw.append(s+"\n");
			}
			bw.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
//	public static void main(String[] args) {
//		getProvince();
//	}
}
