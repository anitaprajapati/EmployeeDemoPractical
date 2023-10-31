package com.DemoPractical.ServiceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DemoPractical.Config.ResourceNotFoundException;
import com.DemoPractical.Model.MstEmployeeBo;
import com.DemoPractical.Model.WebJSONBo;
import com.DemoPractical.Repo.MstEmployeeRepo;
import com.DemoPractical.Repo.MstModuleRepo;
import com.DemoPractical.Service.UserDataService;

@Service
public class UserDataServiceImpl implements UserDataService {

	@Autowired MstEmployeeRepo mstEmployeeRepo;
	@Autowired MstModuleRepo moRepo;

	// Save Employee Data
	@Transactional(rollbackOn = Exception.class)
	public WebJSONBo saveEmployeeDetails(MstEmployeeBo userBo) throws Exception {
		WebJSONBo retBo = new WebJSONBo();
		mstEmployeeRepo.save(userBo);
		if (userBo != null && userBo.getEmpId() > 0) {
			retBo.setStatus("SUCCESS");
			retBo.setReturn_message("Employee data Saved successfully");
			retBo.setResponseData(userBo);
			return retBo;
		} else {
			throw new Exception("Error while save the data");
		}
	}

	// Update Employee Data
	@Transactional(rollbackOn = Exception.class)
	public WebJSONBo updateEmployeeDetailsByEmpId(MstEmployeeBo userBo) throws Exception {
		WebJSONBo retBo = new WebJSONBo();
		Optional<MstEmployeeBo> getBo = mstEmployeeRepo.findById(userBo.getEmpId());

		if (getBo.isPresent()) {
			MstEmployeeBo newBo = getBo.get();
			newBo.setDob(userBo.getDob());
			newBo.setEmpName(userBo.getEmpName());
			newBo.setGender(userBo.getGender());
			newBo.setMobileNo(userBo.getMobileNo());
			newBo.setQualification(userBo.getQualification());
			newBo.setModList(userBo.getModList());
			newBo.setLstUpdDate(userBo.getLstUpdDate());
			newBo.setLstUpdIp(userBo.getLstUpdIp());
			newBo.setLstUpdUser(userBo.getLstUpdUser());
			mstEmployeeRepo.save(newBo);
			retBo.setStatus("SUCCESS");
			retBo.setReturn_message("Employee Details updated Successsfully");
			retBo.setResponseData(newBo);
		} else {
			throw new ResourceNotFoundException("User Not Found");
		}

		return retBo;
	}

	// Delete Employee Data
	@Transactional(rollbackOn = Exception.class)
	public WebJSONBo deleteEmployeeDetailsByEmpId(MstEmployeeBo userBo) throws Exception {
		WebJSONBo webBo = new WebJSONBo();
		Optional<MstEmployeeBo> getBo = mstEmployeeRepo.findById(userBo.getEmpId());

		if (getBo.isPresent()) {
			    mstEmployeeRepo.deleteEmpByEmpId(userBo.getLstUpdDate(), userBo.getLstUpdUser(),userBo.getLstUpdIp(), userBo.getEmpId());
				webBo.setStatus("SUCCESS");
				webBo.setReturn_message("Employee id=" + userBo.getEmpId() + " Details Deleted");
		} else {
			throw new ResourceNotFoundException("User Not Found");
		}
		return webBo;
	}

	// Get Employee Data
	public WebJSONBo getEmployeeDetails() {
		WebJSONBo webBo = new WebJSONBo();
		List<MstEmployeeBo> empList = mstEmployeeRepo.findByStatus("1");
		webBo.setStatus("SUCCESS");
		webBo.setResponseData(empList);
		return webBo;
	}

}
