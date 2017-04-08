package pers.zander.edu.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 取出手机号中的不需要的部分
 * @author zhaozhao
 * @time 2016-5-10 下午4:52:58
 */
public class ClearPhone {

	
	public static void clearPhone(){
		String oldAndroidPath = "D:/phone/android.txt";
		String oldIosPath = "D:/phone/ios.txt";
		String newAndroidPath = "D://phone/android_new.txt";
		String newIosPath = "D://phone/ios_new.txt";
		
		String black = "D:/phone/black.txt";
    	FileReader reader;
    	FileWriter writer ;
    	BufferedReader br;
    	BufferedWriter bw;
    	
    	
    	try {
    		Map<String, String> ph = new HashMap<String, String>() ;
    		reader = new FileReader(oldIosPath);
    		br = new BufferedReader(reader);
    		String str = null;
    		int in =  0;
    		while((str = br.readLine()) != null) {
    			in++;
    			if(!(str.contains("666")||str.contains("888")||str.startsWith("1330")||str.startsWith("1890"))){
    				ph.put(str,"1");
    			}
    		}
    		System.out.println("原始手机号数量："+in);
    		System.out.println("第一次过滤后剩余量："+ph.size());
    		
    		
    		reader = new FileReader(black);
    		br = new BufferedReader(reader);
    		String s = null;
    		int index = 0;
    		while((s = br.readLine()) != null) {
    			if(ph.get(s)!=null&&ph.get(s)=="1"){
    				ph.remove(s);
    			}
    			index++;
    		}
    		System.out.println(index);
    		System.out.println("第二次剔除后剩余："+ph.size());
    		
    		writer =  new FileWriter(newIosPath);
			bw = new BufferedWriter(writer);
    		
			for (Map.Entry<String, String> entry : ph.entrySet()) {
				bw.append(entry.getKey()+"\n");
			}
    		br.close();
    		reader.close();
    		bw.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void clearBj(){
		String oldAndroidPath = "D:/phone/android_new.txt";
		String oldIosPath = "D:/phone/ios_new.txt";
		String newAndroidPath = "D://phone/android_newest.txt";
		String newIosPath = "D://phone/ios_newest.txt";
		FileReader reader;
    	FileWriter writer ;
    	BufferedReader br;
    	BufferedWriter bw;
		try {
			Map<String, String> ph = new HashMap<String, String>() ;
    		reader = new FileReader(oldIosPath);
    		br = new BufferedReader(reader);
    		String str = null;
    		while((str = br.readLine()) != null) {
    			ph.put(str,"1");
    		}
    		System.out.println("读取完成开始过滤北京手机号");
    		writer =  new FileWriter(newIosPath);
			bw = new BufferedWriter(writer);
    		
			for (Map.Entry<String, String> entry : ph.entrySet()) {

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
				String pro = (String) pmap.get("province");
				if(!("北京".equals(pro))){
					bw.append(entry.getKey()+"\n");
				}
			}
    		br.close();
    		reader.close();
    		bw.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
//	public static void main(String[] args) {
//		ClearPhone.clearBj();
//	}
}
