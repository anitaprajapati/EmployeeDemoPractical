package com.DemoPractical.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mst_module")
public class MstModuleBo {

	@Id
	@Column(name = "module_id")
	private int moduleId;
	
	@Column(name = "module_name")
	private String moduleName;
	
	@Column(name = "crt_date",updatable = false,nullable = false)
	private Date crtDate;
	
	@Column(name = "crt_user",updatable = false,nullable = false)
	private String crtUser;
	
	@Column(name = "crt_ip",updatable = false,nullable = false)
	private String crtIp;
	
	@Column(name = "status",updatable = false,nullable = false)
	private String status;

	@ManyToMany(mappedBy = "modList")
	@JsonIgnore
	List<MstEmployeeBo> empList;
	
	public List<MstEmployeeBo> getEmpList() {
		return empList;
	}

	public void setEmpList(List<MstEmployeeBo> empList) {
		this.empList = empList;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public String getCrtUser() {
		return crtUser;
	}

	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	public String getCrtIp() {
		return crtIp;
	}

	public void setCrtIp(String crtIp) {
		this.crtIp = crtIp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
