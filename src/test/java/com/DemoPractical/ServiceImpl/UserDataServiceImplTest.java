package com.DemoPractical.ServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.DemoPractical.Config.ResourceNotFoundException;
import com.DemoPractical.Model.MstEmployeeBo;
import com.DemoPractical.Model.MstModuleBo;
import com.DemoPractical.Model.WebJSONBo;
import com.DemoPractical.Repo.MstEmployeeRepo;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class UserDataServiceImplTest {

    @Mock
    MstEmployeeRepo mstEmployeeRepo;
    
    @InjectMocks
    private UserDataServiceImpl userDataService;
    
    
	@Test
	public void testSaveEmployeeDetails_usingMock() throws Exception
    {
		 MstEmployeeBo employee = new MstEmployeeBo();
		 employee.setEmpId(8);
		 employee.setEmpName("Test5");
		 employee.setGender("Male");
		 employee.setMobileNo("9856856569");
		 employee.setQualification("College");
		 SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
		 employee.setDob(dateFormate.parse("12/05/1995"));
		 employee.setCrtDate(new Date());
		 employee.setCrtUser("TestUser");
		 employee.setCrtIp("0.0.0.1");
		 employee.setStatus("1");
		 
		 MstModuleBo md1 = new MstModuleBo();
		 md1.setModuleId(2);
		 MstModuleBo md2 = new MstModuleBo();
		 md2.setModuleId(3);
		 
		 List<MstModuleBo> modulList = new ArrayList<MstModuleBo>();
		 modulList.add(md1);
		 modulList.add(md2);
		 
		 employee.setModList(modulList);
		 when(mstEmployeeRepo.save(any(MstEmployeeBo.class))).thenReturn(employee);
			
		 WebJSONBo retbo =  userDataService.saveEmployeeDetails(employee);
		
		 assertNotNull(retbo);
		 assertThat(retbo.getResponseData()).isEqualTo(employee);
	  }
	
	 @Test(expected = Exception.class)
     public void testExceptionWhileSaveData() throws Exception {

		 MstEmployeeBo employee = new MstEmployeeBo();
		 when(mstEmployeeRepo.save(any(MstEmployeeBo.class))).thenReturn(employee);
			
		 WebJSONBo retbo =  userDataService.saveEmployeeDetails(employee);
    }
	
	@Test
	public void testUpdateEmployeeDetails_usingMock() throws Exception
    {
		 MstEmployeeBo employee = new MstEmployeeBo();
		 employee.setEmpId(1);
		 
		 when(mstEmployeeRepo.findById(anyInt())).thenReturn(Optional.of(employee));
		 when(mstEmployeeRepo.save(any(MstEmployeeBo.class))).thenReturn(employee);
			
		 employee.setEmpName("Test5");
		 employee.setGender("Male");
		 employee.setMobileNo("9856856569");
		 employee.setQualification("College");
		 SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
		 employee.setDob(dateFormate.parse("12/05/1995"));
		 employee.setLstUpdDate(new Date());
		 employee.setLstUpdUser("Test5");
		 employee.setLstUpdIp("0.0.0.1");
		 
		 MstModuleBo md1 = new MstModuleBo();
		 md1.setModuleId(1);
		 MstModuleBo md2 = new MstModuleBo();
		 md2.setModuleId(2);
		 
		 List<MstModuleBo> modulList = new ArrayList<MstModuleBo>();
		 modulList.add(md1);
		 modulList.add(md2);
		 
		 employee.setModList(modulList);
		 
		 WebJSONBo retbo =  userDataService.updateEmployeeDetailsByEmpId(employee);
		
		 assertNotNull(retbo);
		 MstEmployeeBo ret = (MstEmployeeBo) retbo.getResponseData();
		 assertThat("Test5".equals(ret.getEmpName()));
		    
	  }
	
	 
	@Test
	public void testDeleteEmployeeDetails_usingMock() throws Exception
    {
		 MstEmployeeBo employee = new MstEmployeeBo();
		 employee.setEmpId(1);
		 
		 when(mstEmployeeRepo.findById(anyInt())).thenReturn(Optional.of(employee));
		 when(mstEmployeeRepo.deleteEmpByEmpId(any(Date.class),anyString(),anyString(),anyInt())).thenReturn(anyInt());
		
		 WebJSONBo retbo =  userDataService.deleteEmployeeDetailsByEmpId(employee);
		
		 assertThat(retbo.getStatus().equals("SUCCESS"));
		    
	  }
	
	@Test
	public void testGetEmployeeDetails_usingMock() throws Exception
    {
		 MstEmployeeBo b1 = new MstEmployeeBo();
		 MstEmployeeBo b2 = new MstEmployeeBo();
		 List<MstEmployeeBo> empList = new ArrayList<MstEmployeeBo>();
		 empList.add(b1);
		 empList.add(b2);

		 when(mstEmployeeRepo.findByStatus("1")).thenReturn(empList);  
		 WebJSONBo result = userDataService.getEmployeeDetails();
		 assertEquals(empList, result.getResponseData());
		    
	 }
}
