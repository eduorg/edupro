package pers.zander.edu.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pers.zander.edu.user.domain.SysUser;
import pers.zander.edu.user.service.SysUserService;
import pers.zander.edu.user.web.model.SysUserModel;
import pers.zander.edu.utils.ParamUtil;
import pers.zander.edu.web.BaseController;

@RestController
@RequestMapping(value = "/login")
public class LoginController extends BaseController {
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 用户登录
	 * 
	 * @author zhaozhao
	 * @time 2016-3-23 下午9:10:21
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/slogin" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public Map<String, Object> login(HttpServletResponse response,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String name = ParamUtil.getStr(request, "name", "");
			String tel = ParamUtil.getStr(request, "tel", "");
			SysUserModel model = new SysUserModel();
			model.setName(name);
			model.setTel(tel);
			List<SysUser> slist = sysUserService.getBean(model);
			if(slist!=null&&slist.size()>0){
				SysUser su = slist.get(0);
				request.getSession().setAttribute("name", su.getName());
				request.getSession().setAttribute("tel", su.getTel());
				request.getSession().setMaxInactiveInterval(300);
				result.put("mes", "ok");
			} else {
				result.put("mes", "no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 注销登陆
	 * @author zhaozhao
	 * @time 2016-4-7 下午4:23:40
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/slogout" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public Map<String, Object> logout(HttpServletResponse response,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			request.getSession().setAttribute("name", null);
			request.getSession().setAttribute("tel", null);
			result.put("mes", "ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
