package pers.zander.edu.user.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pers.zander.edu.user.domain.SysUser;
import pers.zander.edu.user.service.SysUserService;
import pers.zander.edu.user.web.model.SysUserModel;
import pers.zander.edu.utils.JSONUtils;
import pers.zander.edu.utils.StringUtils;
import pers.zander.edu.web.BaseController;

@RestController
@RequestMapping(value = "/sysuser")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 新增用户
	 * 
	 * @author zhaozhao
	 * @time 2016-3-22 上午9:30:52
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/addUser" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public SysUser add(HttpServletResponse response, HttpServletRequest request) {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		SysUser su = new SysUser(name, phone);
		sysUserService.addBean(su);
		return su;
	}

	/**
	 * 姓名模糊查询用户
	 * 
	 * @author zhaozhao
	 * @time 2016-3-22 上午9:31:06
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/getUser" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public Map<String, Object> getUser(HttpServletResponse response,
			HttpServletRequest request) {
		String sname = request.getParameter("sname");
		SysUserModel model = new SysUserModel();
		sname = StringUtils.encodingTool(sname);
		model.setName(sname);
		List<SysUser> list = new ArrayList<SysUser>();
		list = sysUserService.getBean(model);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", "0");
		result.put("mes", "ok");
		result.put("datas", list);
		return result;
	}

	/**
	 * id精确查询用户
	 * 
	 * @author zhaozhao
	 * @time 2016-3-22 上午9:31:17
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/getUserById" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public SysUser getUserById(HttpServletResponse response,
			HttpServletRequest request) {
		String sid = request.getParameter("sid");
		SysUserModel model = new SysUserModel();
		model.setId(Long.parseLong(sid));
		SysUser bean = sysUserService.getBeanById(model);
		return bean;
	}

	/**
	 * 查询全部用户
	 * 
	 * @author zhaozhao
	 * @time 2016-3-22 上午9:31:27
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/getAllUser" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public String getAllUser(HttpServletResponse response,
			HttpServletRequest request) {
		List<SysUser> list = sysUserService.getAllBean();
		System.out.println(JSONUtils.objectToJson(list).toString());
		return JSONUtils.objectToJson(list).toString();
	}
	/**
	 * 
	 * @author zhaozhao
	 * @time 2016-3-22 下午5:51:28
	 * @param response
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/getMenu" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public String getMenu(HttpServletResponse response,
			HttpServletRequest request) {
		String s = "[";
		s+="{\"id\":12,\"name\":\"哈哈\",\"pid\":\"12\"},";
		s+="{\"id\":13,\"name\":\"哈哈\",\"pid\":12},";
		s+="{\"id\":14,\"name\":\"哈哈\",\"pid\":12}";
		s+="]";
		System.out.println(s);
		return s;
	}

	/**
	 * 删除用户
	 * @author zhaozhao
	 * @time 2016-3-22 下午4:45:46
	 * @param response
	 * @param request
	 */
	@ResponseBody
	@RequestMapping(value = { "/delUser" }, method = { RequestMethod.POST,
			RequestMethod.GET })
	public void delUser(HttpServletResponse response, HttpServletRequest request) {
		String id = request.getParameter("id");
		sysUserService.delBean(Long.parseLong(id));

	}

	/**
	 * 分页条件查询展示数据
	 * @author zhaozhao
	 * @time 2016-3-22 下午4:46:28
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/getAllUserPages" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	public Page<SysUser> getAllUserPages(HttpServletResponse response,
			HttpServletRequest request, @ModelAttribute SysUserModel model) {
		Pageable pageable = super.getPageable(request);
		return sysUserService.getBeanByPage(model, pageable);
	}
	/**
	 * 用户登录
	 * @author zhaozhao
	 * @time 2016-3-23 下午9:10:21
	 * @param response
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/login" }, method = {
			RequestMethod.POST, RequestMethod.GET })
	public String login(HttpServletResponse response,
			HttpServletRequest request, @ModelAttribute SysUserModel model) {
		try {
			String name = model.getName();
			String tel = model.getTel();
			request.getSession().setAttribute("name", name);
			request.getSession().setAttribute("tel", tel);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "ok";
	}

}
