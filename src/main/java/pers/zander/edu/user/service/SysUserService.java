package pers.zander.edu.user.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pers.zander.edu.user.domain.SysUser;
import pers.zander.edu.user.web.model.SysUserModel;

/**
 * 业务接口
 * @author 赵召
 * Mar 21, 2016 10:01:16 AM
 */
public interface SysUserService {

	public void addBean(SysUser bean);
	public List<SysUser> getBean(SysUserModel model);
	public SysUser getBeanById(SysUserModel model);
	public List<SysUser> getAllBean();
	public Page<SysUser> getBeanByPage(SysUserModel model,Pageable pageable);
	public void delBean(Long id);
}
