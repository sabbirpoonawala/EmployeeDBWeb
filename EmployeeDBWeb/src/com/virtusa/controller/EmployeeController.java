package com.virtusa.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.converter.DateConverter;
import com.virtusa.helper.FactoryEmployeeDB;
import com.virtusa.model.DepartmentsModel;
import com.virtusa.model.EmployeesModel;
import com.virtusa.model.JobsModel;
import com.virtusa.model.ManagersModel;
import com.virtusa.model.AllEmployeesModel;
import com.virtusa.service.DepartmentsService;
import com.virtusa.service.EmployeesService;
import com.virtusa.service.JobsService;
import com.virtusa.validation.EmployeesModelValidator;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeesService employeeService=null;
    private DepartmentsService departmentService=null;
    private JobsService jobsService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	this.employeeService=FactoryEmployeeDB.createEmployeesService();
    	this.departmentService=FactoryEmployeeDB.createDepartmentsService();
    	this.jobsService=FactoryEmployeeDB.createJobsService();
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action=request.getParameter("action");
		if(action.contentEquals("view")) {
		List<EmployeesModel> employeesModelList=employeeService.retrieveEmployees();
		request.setAttribute("employeesModelList", employeesModelList);
		
		if(!employeesModelList.isEmpty()) {
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("employeedetails.jsp");
			dispatcher.forward(request,response);
		}else {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("noemployeedetails.jsp");
			dispatcher.forward(request,response);
		}
		}
		
		if(action.contentEquals("loadform")) {
			
			List<DepartmentsModel> departmentsList=
					departmentService.retrieveDepartments();
			List<JobsModel> jobsList=jobsService.retrieveJobs();
			List<ManagersModel> managersList=employeeService.getManagers();
			request.setAttribute("departmentsList", departmentsList);
			request.setAttribute("jobsList", jobsList);
			request.setAttribute("managersList", managersList);
			
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("employeeform.jsp");
			dispatcher.forward(request, response);
		}
		
           if(action.contentEquals("viewEmployee")) {
			
			
        	List<AllEmployeesModel> allemployeesList=employeeService.retrieveAllEmployees();
			request.setAttribute("allemployeesList", allemployeesList);
			
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("allemployees.jsp");
			dispatcher.forward(request, response);
		}
           
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        String action=request.getParameter("action");
        if(action.contentEquals("newEmployee")) {
        	
        	int employeeId=Integer.parseInt(request.getParameter("employeeId"));
        	
        	String firstName=request.getParameter("firstName");
        	String lastName=request.getParameter("lastName");
        	String email=request.getParameter("email");
        	
        	String phoneNumber=request.getParameter("phoneNumber");
        	String hire_Date=request.getParameter("hireDate");
        	
        	LocalDate hireDate=DateConverter.convertLocaleDate(hire_Date, "-");
        	String jobId=request.getParameter("jobId");
        	double salary=Double.parseDouble(request.getParameter("salary"));
        	double commissionPCT=Double.parseDouble(request.getParameter("commissionPCT"));
        	int managerId=Integer.parseInt(request.getParameter("managerId"));
        	int departmentId=Integer.parseInt(request.getParameter("departmentId"));
        	
        	EmployeesModelValidator validator=new EmployeesModelValidator();
        	boolean employeeIdExist=validator.employeeIdExists(employeeId);
        	boolean validFirstName=validator.validString(firstName);
        	boolean validLastName=validator.validString(lastName);
        	boolean validEmail=validator.validEmail(email);
        	boolean validSalary=validator.validSalary(salary);
        	boolean emailExist=validator.emailExist(email);
    		
          
        	if(employeeIdExist || !validFirstName || !validLastName || !validEmail || !validSalary || emailExist) {
        		
        		  if(employeeIdExist) {
                  	request.setAttribute("employeeIderror","Employee Id already exist");

                  }
                  if(!validFirstName) {
              		request.setAttribute("firstnameerror", "First Name not valid");
                  }
                  if(!validLastName) {
              		request.setAttribute("lastnameerror",  "Last Name not valid");
                  }
                  if(!validEmail) {
              		request.setAttribute("emailerror",  "Email not valid");

                  }
                  if(!validSalary) {
              		request.setAttribute("salaryerror",  "Salary not valid");

                  }
                  if(emailExist) {
                		request.setAttribute("emailexisterror",  "Email already exist");

                  }
        		
            RequestDispatcher dispatcher=
    				request.getRequestDispatcher("employeeform.jsp");
            List<DepartmentsModel> departmentsList=
					departmentService.retrieveDepartments();
			List<JobsModel> jobsList=jobsService.retrieveJobs();
			List<ManagersModel> managersList=employeeService.getManagers();
			request.setAttribute("departmentsList", departmentsList);
			request.setAttribute("jobsList", jobsList);
			request.setAttribute("managersList", managersList);
    		dispatcher.forward(request,response);
        	}else {
        		AllEmployeesModel employeesModel=new AllEmployeesModel();
        		employeesModel.setEmployeeId(employeeId);
        		employeesModel.setFirstName(firstName);
        		employeesModel.setLastName(lastName);
        		employeesModel.setEmail(email);
        		employeesModel.setPhoneNumber(phoneNumber);
        		employeesModel.setJobId(jobId);
        		employeesModel.setHireDate(hireDate);
        		employeesModel.setSalary(salary);
        		employeesModel.setCommissionPCT(commissionPCT);
        		employeesModel.setDepartmentId(departmentId);
        		employeesModel.setManagerId(managerId);
        		
        		String outcome=employeeService.registerEmployee(employeesModel);
        		if(outcome.contentEquals("success")) {
        			 RequestDispatcher dispatcher=
        	    				request.getRequestDispatcher("employeesuccess.jsp");
        			 request.setAttribute("employeesModel",employeesModel);
           			 request.setAttribute("operation", "Below Employee record Registration was Successfully");

        	    		dispatcher.forward(request,response);
        		}else {
        			 RequestDispatcher dispatcher=
        	    				request.getRequestDispatcher("employeefail.jsp");
           			 request.setAttribute("operation", "Employee Registration Failed");

        	    		dispatcher.forward(request,response);
        		}
        		
        		
        	}


        	
        }
        
        if(action.contentEquals("updateEmployeeForm")) {
        	
        	int employeeId=Integer.parseInt(request.getParameter("employeeId"));
        	RequestDispatcher dispatcher=
    				request.getRequestDispatcher("employeeupdateform.jsp");
        	List<AllEmployeesModel> allEmployees=employeeService.retrieveAllEmployees();
        	AllEmployeesModel allemployeesModel=new AllEmployeesModel();
        	for(AllEmployeesModel employeesModel:allEmployees) {
        		if(employeesModel.getEmployeeId()==employeeId) {
        			allemployeesModel=employeesModel;
        		}
        	}
        	
            List<DepartmentsModel> departmentsList=
					departmentService.retrieveDepartments();
			List<JobsModel> jobsList=jobsService.retrieveJobs();
			List<ManagersModel> managersList=employeeService.getManagers();
			request.setAttribute("allemployeesModel", allemployeesModel);
			request.setAttribute("departmentsList", departmentsList);
			request.setAttribute("jobsList", jobsList);
			request.setAttribute("managersList", managersList);
    		dispatcher.forward(request,response);
        	
        }
        
        if(action.contentEquals("updateEmployee")) {
        	int employeeId=Integer.parseInt(request.getParameter("employeeId"));
        	String firstName=request.getParameter("firstName");
        	String lastName=request.getParameter("lastName");
        	String email=request.getParameter("email");
        	String phoneNumber=request.getParameter("phoneNumber");
        	String jobId=request.getParameter("jobId");
        	double salary=Double.parseDouble(request.getParameter("salary"));
        	double commissionPCT=Double.parseDouble(request.getParameter("commissionPCT"));
        	int managerId=Integer.parseInt(request.getParameter("managerId"));
        	int departmentId=Integer.parseInt(request.getParameter("departmentId"));
            String hire_Date=request.getParameter("hireDate");
        	
        	LocalDate hireDate=DateConverter.convertLocaleDate(hire_Date, "-");
        	AllEmployeesModel employeesModel=new AllEmployeesModel();
    		employeesModel.setEmployeeId(employeeId);
    		employeesModel.setFirstName(firstName);
    		employeesModel.setLastName(lastName);
    		employeesModel.setEmail(email);
    		employeesModel.setPhoneNumber(phoneNumber);
    		employeesModel.setHireDate(hireDate);
    		employeesModel.setJobId(jobId);
    		employeesModel.setSalary(salary);
    		employeesModel.setCommissionPCT(commissionPCT);
    		employeesModel.setDepartmentId(departmentId);
    		employeesModel.setManagerId(managerId);
    		
    		String outcome=employeeService.updateEmployee(employeesModel);
    		System.out.println("outcome:"+outcome);
    		if(outcome.contentEquals("success")) {
   			 RequestDispatcher dispatcher=
   	    				request.getRequestDispatcher("employeesuccess.jsp");
   			 request.setAttribute("employeesModel",employeesModel);
   			 request.setAttribute("operation", "Below Employee record Updated Successfully");
   	    		dispatcher.forward(request,response);
   		}else {
   			 RequestDispatcher dispatcher=
   	    				request.getRequestDispatcher("employeefail.jsp");
   			 request.setAttribute("operation", "Employee Update Failed");

   	    		dispatcher.forward(request,response);
   		}


        }
        if(action.contentEquals("deleteEmployee")) {
        	int employeeId=Integer.parseInt(request.getParameter("employeeId"));
        	AllEmployeesModel employeesModel=new AllEmployeesModel();
        	employeesModel.setEmployeeId(employeeId);
        	String outcome=employeeService.deleteEmployee(employeesModel);
        	List<AllEmployeesModel> allEmployeesList=employeeService.retrieveAllEmployees();
        	for(AllEmployeesModel employees:allEmployeesList) {
        		if(employeesModel.getEmployeeId()==employeeId) {
        			employeesModel=employees;
        		}
        	}
        	if(outcome.contentEquals("success")) {
      			 RequestDispatcher dispatcher=
      	    				request.getRequestDispatcher("employeesuccess.jsp");
      			 request.setAttribute("employeesModel",employeesModel);
      			 request.setAttribute("operation", "Below Employee record deleted Successfully");
      	    		dispatcher.forward(request,response);
      		}else {
      			 RequestDispatcher dispatcher=
      	    				request.getRequestDispatcher("employeefail.jsp");
      			 request.setAttribute("operation", "Employee Delete Failed");

      	    		dispatcher.forward(request,response);
      		}
        }
		
	}

}
