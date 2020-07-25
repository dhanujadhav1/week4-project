package main;

import java.util.Scanner;

import controller.adminLogin;
import dao.accessEmployeeFile;
import model.employeeOperations;

public class integrated {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		adminLogin adminlogin = new adminLogin();

		employeeOperations empoperations = new employeeOperations();
		accessEmployeeFile tosearch = new accessEmployeeFile();

		int idofemployee;
		String nameofemployee, deptofemployee;
		String password, id;
		boolean validadmin = false;
		int choice = 0;

		System.out.println("--------------------------------");
		System.out.println("------------Welcome-------------");
		System.out.println("Please login as admin:");
		System.out.println("Enter admin ID");
		id = sc.next();
		System.out.println("Enter Password");
		password = sc.next();
		// Checking admin credentials
		validadmin = adminlogin.validateAdmin(id, password);

		if (validadmin) {
			System.out.println("--------------------------------");
			System.out.println("--------------------------------");
			System.out.println("Enter\n1:Add new employee \n2:Search employee by Name \n3:Search employee by id");
			System.out.println("4:Search employee by Department \n5:View details of all employee");
			choice = sc.nextInt();
			System.out.println("--------------------------------");
			System.out.println("--------------------------------");
			switch (choice) {
			// To add Employee
			case 1:

				empoperations.addEmployee();
				break;
			// to Search employee by Name
			case 2:
				System.out.println("Enter name of Employee to search:");
				nameofemployee = sc.next();
				tosearch.searchEmployeeByName(nameofemployee);
				break;
			// to Search employee by ID
			case 3:
				System.out.println("Enter Id of Employee");
				idofemployee = sc.nextInt();
				tosearch.getEmployeeById(idofemployee);
				break;
			// to Search employee by Department
			case 4:
				System.out.println("Enter Dept of Employee");
				deptofemployee = sc.next();
				tosearch.searchEmployeeByDept(deptofemployee);
				break;
			// to read details of all employees
			case 5:
				tosearch.readDataToPrintFromEmployee();
				break;

			default:
				System.out.println("Enter valid input");
				break;

			}

		} else
			System.out.println("Enter Valid Credentials");

	}
}
