package com.DemoPractical.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="mst_employee")
public class MstEmployeeBo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int empId;
	
	@Column(name = "emp_name")
	@NotBlank(message = "Please enter Employee Name")
	private String empName;

	@Column(name = "mobile_no")
	@NotBlank(message = "Please enter Valid mobile No")
	@Pattern(regexp="(^$|[0-9]{10})", message = "Please enter 10 digit valid mobile number.")
	private String mobileNo;
	
	@Column(name = "gender")
	@NotBlank(message = "Please enter gender")
	private String gender;
	
	@Column(name = "qualification")
	@NotBlank(message = "Please enter qualification")
	private String qualification;
	
	@Column(name = "crt_date",updatable = false,nullable = false)
	private Date crtDate;
	
	@Column(name = "crt_user",updatable = false,nullable = false)
	private String crtUser;
	
	@Column(name = "crt_ip",updatable = false,nullable = false)
	private String crtIp;
	
	@Column(name = "status",updatable = false,nullable = false)
	private String status;

	@Column(name = "lst_upd_date")
	private Date lstUpdDate;
	
	@Column(name = "lst_upd_user")
	private String lstUpdUser;
	
	@Column(name = "lst_upd_ip")
	private String lstUpdIp;
	
	@Column(name = "dob")
	private Date dob;
	
	@Transient
	private String dob_temp;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="mpg_module",joinColumns = {@JoinColumn(name="emp_id", referencedColumnName = "emp_id")},
		inverseJoinColumns = {@JoinColumn(name="module_id", referencedColumnName = "module_id")})
	List<MstModuleBo> modList ; 

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDob_temp() {
		return dob_temp;
	}

	public void setDob_temp(String dob_temp) {
		this.dob_temp = dob_temp;
	}

	public List<MstModuleBo> getModList() {
		return modList;
	}

	public void setModList(List<MstModuleBo> modList) {
		this.modList = modList;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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

	public Date getLstUpdDate() {
		return lstUpdDate;
	}

	public void setLstUpdDate(Date lstUpdDate) {
		this.lstUpdDate = lstUpdDate;
	}

	public String getLstUpdUser() {
		return lstUpdUser;
	}

	public void setLstUpdUser(String lstUpdUser) {
		this.lstUpdUser = lstUpdUser;
	}

	public String getLstUpdIp() {
		return lstUpdIp;
	}

	public void setLstUpdIp(String lstUpdIp) {
		this.lstUpdIp = lstUpdIp;
	}

			
}
