package pers.zander.edu.utils;

import java.io.UnsupportedEncodingException;
/**
 * 字符串工具类
 * @author zhaozhao
 * @time 2016-3-21 下午5:17:03
 */
public class StringUtils {

	/**
	 * 转为UTF-8
	 * @author zhaozhao
	 * @time 2016-3-21 下午5:17:19
	 * @param str
	 * @return
	 */
	public static String encodingTool(String str) {
		String r = "";
		try {
			r = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return r;
	}
}
