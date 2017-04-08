package pers.zander.edu.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import pers.zander.edu.utils.ParamUtil;

public class BaseController {

	public Pageable getPageable(HttpServletRequest request)
    {
        int number = ParamUtil.getIntParamter(request, "number", 0);
        int size = ParamUtil.getIntParamter(request, "size", 10);
        String sortField = ParamUtil.getStr(request, "sortField", "");
        String sortOrder = ParamUtil.getStr(request, "sortOrder", "desc");
        Sort sort = null;
        if(!"".equals(sortField))
            sort = new Sort(org.springframework.data.domain.Sort.Direction.fromString(sortOrder), new String[] {
                sortField
            });
        Pageable pageable = new PageRequest(number, size, sort);
        return pageable;
    }
	
}
