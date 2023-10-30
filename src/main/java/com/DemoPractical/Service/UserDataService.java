package com.DemoPractical.Service;

import com.DemoPractical.Model.MstEmployeeBo;
import com.DemoPractical.Model.WebJSONBo;

public interface UserDataService {

	WebJSONBo saveEmployeeDetails(MstEmployeeBo userBo) throws Exception;

	WebJSONBo updateEmployeeDetailsByEmpId(MstEmployeeBo userBo) throws Exception;

	WebJSONBo deleteEmployeeDetailsByEmpId(MstEmployeeBo userBo) throws Exception;
	
	WebJSONBo getEmployeeDetails();

	
}
