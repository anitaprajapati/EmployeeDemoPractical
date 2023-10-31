package com.DemoPractical.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DemoPractical.Model.MstEmployeeBo;
import com.DemoPractical.Model.WebJSONBo;
import com.DemoPractical.Service.UserDataService;

@RestController
@RequestMapping("/UserData")
public class UserDataController {

	/**
	 * AUTHOR::ANITA PRAJAPATI DATE::29-OCT-2023 PURPOSE:: EMPLOYEE CRUD OPERATION
	 */

	// Costructor Dependecy Injection
	@Autowired
	UserDataService userDataService;

	SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");

	@GetMapping("/")
	public ResponseEntity<WebJSONBo> loadHomePage(HttpServletRequest req, HttpServletResponse res) throws Exception {
		WebJSONBo retBo = new WebJSONBo();
		retBo.setStatus("SUCCESS");
		retBo.setReturn_message("Welcome to the home Page");
		return ResponseEntity.ok(retBo);
	}

	/**
	 * PURPOSE:: METHOD TO SAVE THE EMPLOYEE DATA
	 */
	@PostMapping(value = "saveEmployeeDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebJSONBo> saveUserDetails(@RequestBody @Valid MstEmployeeBo userBo, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		
			userBo.setCrtDate(new Date());
			userBo.setCrtIp(getIpAddress(req));
			userBo.setCrtUser("Admin");
			userBo.setStatus("1");
			if (userBo.getDob_temp() != null && !("").equalsIgnoreCase(userBo.getDob_temp())) {
				userBo.setDob(dateFormate.parse(userBo.getDob_temp()));
			}
			WebJSONBo retBo = userDataService.saveEmployeeDetails(userBo);
			return ResponseEntity.ok(retBo);
	}

	/**
	 * PURPOSE:: METHOD TO UPDATE THE EMPLOYEE DATA
	 */
	@PostMapping(value = "updateEmployeeDetailsByEmpId", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebJSONBo> updateEmployeeDetailsByEmpId(@Valid @RequestBody MstEmployeeBo userBo,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		userBo.setLstUpdDate(new Date());
		userBo.setLstUpdIp(getIpAddress(req));
		userBo.setLstUpdUser("Admin");
		if (userBo.getDob_temp() != null && !("").equalsIgnoreCase(userBo.getDob_temp())) {
			userBo.setDob(dateFormate.parse(userBo.getDob_temp()));
		}
		WebJSONBo retBo = userDataService.updateEmployeeDetailsByEmpId(userBo);
		return ResponseEntity.ok(retBo);
	}

	/**
	 * PURPOSE:: METHOD TO DELETE THE EMPLOYEE DATA
	 */
	@PostMapping(value = "deleteEmployeeDetailsByEmpId", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebJSONBo> deleteEmployeeDetailsByEmpId(@RequestBody MstEmployeeBo userBo,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		userBo.setLstUpdDate(new Date());
		userBo.setLstUpdIp(getIpAddress(req));
		userBo.setLstUpdUser("Admin");

		WebJSONBo retBo = userDataService.deleteEmployeeDetailsByEmpId(userBo);
		return ResponseEntity.ok(retBo);
	}

	/**
	 * PURPOSE:: METHOD TO GET THE EMPLOYEE DATA
	 */
	@GetMapping(value = "getEmployeeDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebJSONBo> getEmpOtherDetailsById(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		WebJSONBo retBo = userDataService.getEmployeeDetails();
		return ResponseEntity.ok(retBo);
	}

	/**
	 * PURPOSE:: METHOD TO GET IP ADDRESS
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String usrIp = request.getHeader("X-FORWARDED-FOR");
		if (usrIp == null || usrIp == "") {
			usrIp = request.getRemoteAddr();
		}
		return usrIp;
	}

}
