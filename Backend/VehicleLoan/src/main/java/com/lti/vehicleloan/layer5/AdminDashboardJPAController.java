package com.lti.vehicleloan.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.vehicleloan.layer2.AdvancedUserDetail;
import com.lti.vehicleloan.layer2.EmploymentDetail;
import com.lti.vehicleloan.layer2.LoanDetail;
import com.lti.vehicleloan.layer2.UserDetail;
import com.lti.vehicleloan.layer4.AdminDashboardServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminDashboardJPAController {

	@Autowired
	AdminDashboardServiceImpl adminDashboardService;
	public AdminDashboardJPAController() {
		System.out.println("AdminDashboardJPAController().. constructed");
	}
		
		//get all loan details
	    //http://localhost:8090/admin/getAllLoanDetails
		@GetMapping
		@ResponseBody
		@RequestMapping(value="/getAllLoanDetails")
		public List<LoanDetail> getAllLoanDetails(){
			return adminDashboardService.selectAllLoanDetailsService(); //from the db
		}
	
		//http://localhost:8090/admin/modifyApproval
		@PutMapping
		@ResponseBody
		@RequestMapping(value="/modifyApproval")
		public void modifyApproval(@RequestBody LoanDetail loanDetail)
		{
			System.out.println("modify Approval().. method");
			//return adminDashboardService.updateApprovalService(loanDetail); 
			adminDashboardService.updateApprovalService(loanDetail);
			
		}
		
		//http://localhost:8090/admin/deleteLoan/502
		@ResponseBody
		@DeleteMapping(value="/deleteLoan/{loanId}")
		public void deleteLoan(@PathVariable int loanId) {
			System.out.println("deleteLoan().. method");
			adminDashboardService.deleteLoanDetailService(loanId);
		}
		
		//http://localhost:8090/admin/getLoanDetailbyLoanId/503
		@GetMapping
		@ResponseBody
		@RequestMapping(value="/getLoanDetailbyLoanId/{loanId}")
		
		public LoanDetail getLoanDetailbyLoanId(@PathVariable int loanId) {
			return adminDashboardService.selectLoanDetailbyloanIdService(loanId);
		}
		
		//http://localhost:8090/admin/getLoanDetailbyApproval/pending
		@GetMapping
		@ResponseBody
		@RequestMapping(value="/getLoanDetailbyApproval/{approval}")
		public List<LoanDetail> getLoanDetailbyApproval(@PathVariable String approval)
		{
			return adminDashboardService.selectLoanDetailbyApprovalService(approval);
		}
		
		//http://localhost:8090/admin/getAllAdvancedUserDetails
		@GetMapping
		@ResponseBody
		@RequestMapping(value="/getAllAdvancedUserDetails")
		public List<AdvancedUserDetail> getAllAdvancedUserDetails(){
			return adminDashboardService.selectAllAdvancedUserDetailService();
		}
		
		//http://localhost:8090/admin/getAdvancedUserDetailByUserId/301
		@GetMapping
		@ResponseBody
		@RequestMapping(value="/getAdvancedUserDetailByUserId/{userId}")
		public AdvancedUserDetail getAdvancedUserDetailByUserId(@PathVariable int userId)
		{
			return adminDashboardService.getAdvancedUserDetailByUserIdService(userId);
		}
		
		//http://localhost:8090/admin/getAdvancedUserDetailByLoanId/501
		@GetMapping
		@ResponseBody
		@RequestMapping(value="/getAdvancedUserDetailByLoanId/{loanId}")
		public AdvancedUserDetail getAdvancedUserDetailByLoanId(@PathVariable int loanId)
		{
			return adminDashboardService.getAdvancedUserDetailByLoanIdService(loanId);
		}
		
		//http://localhost:8090/admin/getEmploymentDetailByLoanId/501
		@GetMapping
		@ResponseBody
		@RequestMapping(value="/getEmploymentDetailByLoanId/{loanId}")
		public List<EmploymentDetail> getEmploymentDetailByLoanId(@PathVariable int loanId)
		{
			return adminDashboardService.getEmploymentDetailByLoanIdService(loanId);
		}
		
		//http://localhost:8090/admin/getAllUserDetails
		@GetMapping
		@ResponseBody
		@RequestMapping(value="/getAllUserDetails")
		public List<UserDetail> getAllUserDetails(){
			return adminDashboardService.selectAllUserDetailsService();
		}
		
		
	}

