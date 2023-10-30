package com.DemoPractical.ServiceImpl;

import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.DemoPractical.Service.UserDataService;

public class UserDataServiceImplTest {

	UserDataServiceImpl userSerImpl;
	UserDataService userServi;
	
	 public UserDataServiceImplTest(UserDataService userServi)
	    {
	        this.userServi = userServi;
	    }
	 
	
	
	@Test
	public void testGetEmployeeDetailsRelatedToSpring_usingMock()
    {
//       
//        when(userServi.getEmployeeDetails())
//            .thenReturn("2");
// 
//        assertEquals(1, getEmployeeDetails.size());
    }

}
