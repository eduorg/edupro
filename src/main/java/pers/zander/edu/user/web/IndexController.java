package pers.zander.edu.user.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.zander.edu.web.BaseController;

@RestController
public class IndexController extends BaseController {
	@RequestMapping(value={"/",""})
	public String index() {
		return "<a href=\"/edupro/system/index.html\">返回首页</a>";
	}
}
