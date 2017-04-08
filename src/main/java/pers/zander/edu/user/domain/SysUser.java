package pers.zander.edu.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 实体类 -用户
 * @author 赵召
 * Mar 21, 2016 10:00:53 AM
 */
@Entity
@Table(name="SYSUSER")
public class SysUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name="SYSUSER_SEQ")
	@Column(name="ID")
	private Long id ;
	@Column(name="USERNAME")
	private String name ;
	@Column(name="TEL")
	private String tel ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public SysUser(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	public SysUser() {
		super();
	}
	
}
