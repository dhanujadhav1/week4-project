package model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.accessAdminData;
import dao.accessEmployeeFile;

public class employeeOperations {
	static int rowCountEmp = 0;
	static int rowCountAdmin = 0;

	// Method to add new Employee in employee Excel Sheet
	public void addEmployee() {

		Scanner addE = new Scanner(System.in);

		try {
			System.out.println("Enter employee ID");

			int id = addE.nextInt();

			System.out.println("Enter employee Name");
			String name = addE.next();
			System.out.println("Enter date of birth of Employee, Years of experiance of Employee ");
			String dob = addE.next();
			int experiance = addE.nextInt();
			System.out.println("Enter Dept of employee ");
			String dept = addE.next();
			// Password validation for addEmployee method
			String password;
			boolean isvalid = false;
			do {
				System.out.println("Enter Valid password to create login system");
				System.out.println(
						"Password must have atleast one capital alphabate, ane digit and one special character");
				password = addE.next();
				isvalid = passwordValidate(password);

			} while (isvalid == false);
			Employee emp = new Employee(id, name, dob, experiance, dept, password);
			System.out.println("Do you want to add expenses enter y/n");
			String choice = addE.next();
			choice.trim();
			if (choice.equals("y") || choice.equals("Y")) {
				System.out.println("How many expenses do you want to add");
				int howmany = addE.nextInt();
				String expenseName;
				int expenseAmount;
				String expenseDesc;
				for (int i = howmany; i >= 1; i--) {
					System.out.println("Enter reason (i.e. Name, ex-Taxpay etc) of Expense");
					expenseName = addE.next();
					System.out.println("Enter expense amount");
					expenseAmount = addE.nextInt();
					System.out.print("Enter Discription of Expense");
					expenseDesc = addE.next();
					Expenses expd = new Expenses(expenseName, expenseAmount, expenseDesc);
					emp.expenses.add(expd);

				}
			}
			accessEmployeeFile empData = new accessEmployeeFile();
			int temp = empData.writeDataToEmployee(emp, rowCountEmp);
			rowCountEmp = temp;
			addE.close();
			System.out.println("employee is added successfully");

		} catch (Exception e) {

		}

	}

	// Method to add new admin
	public void addAdmin() {
		Scanner addA = new Scanner(System.in);
		System.out.println("Enter Admin ID, Enter Admin Name");
		String id = addA.nextLine();
		String name = addA.nextLine();
		// Password validation for addAdmin method
		String password;
		boolean isvalid = false;
		do {
			System.out.println("Enter Valid password to create login system");
			System.out.println("Password must have atleast one capital alphabate, ane digit and one special character");
			password = addA.nextLine();
			isvalid = passwordValidate(password);

		} while (isvalid == false);

		Admin admin = new Admin(name, id, password);
		accessAdminData adminData = new accessAdminData();
		adminData.writeDataToAdmin(admin, rowCountAdmin);
		System.out.println("Admin is added successfully");
		addA.close();
	}

	// Function to validate the password.
	public boolean passwordValidate(String password) {// Regex to check valid password.
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		// Compile the ReGex
		Pattern p = Pattern.compile(regex);
		// If the password is empty
		// return false
		if (password == null) {
			return false;
		}
		Matcher m = p.matcher(password);
		return m.matches();
	}

}
