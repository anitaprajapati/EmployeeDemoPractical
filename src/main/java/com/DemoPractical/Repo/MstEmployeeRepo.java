package com.DemoPractical.Repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DemoPractical.Model.MstEmployeeBo;

@Repository
public interface MstEmployeeRepo extends JpaRepository<MstEmployeeBo, Integer>{
	
	@Query("from MstEmployeeBo where status = :Status")
	public List<MstEmployeeBo> findByStatus(String Status);
	
	@Modifying
	@Query(value = "update mst_employee set status='0',lst_upd_date=?1,lst_upd_user=?2,lst_upd_ip=?3 where emp_id=?4",nativeQuery = true)
	public int deleteEmpByEmpId(Date updDate,String updUSer,String updIp,int empId);
	
}
