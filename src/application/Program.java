package application;

import java.util.ArrayList;
import java.util.List;

import entities.BasePlusCommissionEmployee;
import entities.ComissionEmployee;
import entities.Employee;
import entities.HourEmployee;
import entities.SalariedEmployee;

public class Program {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		
		SalariedEmployee salariedEmployee = 
				new SalariedEmployee("John","Smith","111-11-111", 800.00);
		
		list.add(salariedEmployee);
		
		HourEmployee hourEmployee = 
				new HourEmployee("Karen","Price","222-22-2222", 16.75, 40);
		
		list.add(hourEmployee);
		
		ComissionEmployee comissionEmployee = 
				new ComissionEmployee("Sue","Jones","333-33-3333",10000, .06);
		
		list.add(comissionEmployee);

		BasePlusCommissionEmployee basePlusCommissionEmployee =
				new BasePlusCommissionEmployee("Bob","Lewis","444-44-444",5000, .04,300);
		
		list.add(basePlusCommissionEmployee);
		
		System.out.println("Employees processed individually:");
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n",salariedEmployee,
				"earned",salariedEmployee.earnings());
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n",hourEmployee,
				"earned",hourEmployee.earnings());
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n",comissionEmployee,
				"earned", comissionEmployee.earnings());
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n",basePlusCommissionEmployee,
				"earned",basePlusCommissionEmployee.earnings());
		
		System.out.printf("Employees processed Polymorphically:%n%n");
		
		for (Employee currentEmployee : list) {
			System.out.println(currentEmployee);
			
			if(currentEmployee instanceof BasePlusCommissionEmployee) {
				
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee)
						currentEmployee;
				
				//aumentar o salário base de cada funcionário em 10%
				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				
				System.out.printf("earned $%,.2f%n%n",currentEmployee.earnings());
			}
				
			for (int i = 0; i < list.size(); i++) {
				
				System.out.printf("Employee %d is a %s%n ",i,list.get(i).getClass().getName());
				
			}
				
		}
		
	}

}
