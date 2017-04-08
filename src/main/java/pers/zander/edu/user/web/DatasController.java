package pers.zander.edu.user.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pers.zander.edu.web.BaseController;

@RestController
@RequestMapping(value = "/data")
public class DatasController extends BaseController {
	@ResponseBody
	@RequestMapping(value = { "/json" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public Map<String, String> getJson(HttpServletResponse response,
			HttpServletRequest request) {
		System.out.println("调用接口>>>" + new Date());
		Map<String, String> result = new HashMap<String, String>();
		result.put("a", "a111");
		result.put("b", "b111");
		result.put("c", "c111");
		return result;
	}

	@ResponseBody
	@RequestMapping(value = { "/data" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public byte[] getData(HttpServletResponse response,
			HttpServletRequest request) {

		response.setContentType("application/octet-stream");
		OutputStream out;
		try {
			out = response.getOutputStream();
			byte[] reBytes = { 1, 2, 3 };
			String a = "JK101";
			out.write(a.getBytes());
			out.write(reBytes);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
