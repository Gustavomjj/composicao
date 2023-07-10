package Nelio.composicao.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Nelio.composicao.entities.Departament;
import Nelio.composicao.entities.HourContract;
import Nelio.composicao.entities.Worker;
import Nelio.composicao.entities.enums.WorkerLevel;

public class application {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		System.out.print("Enter departament's name: ");
		String departamentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));
		
		System.out.print("How many contracts to this worker? ");
		int contracts = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < contracts; i++) {
			System.out.printf("Enter contract #%d data: ", i+1);
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int durationHours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, durationHours);
			worker.addContract(contract);
		}

		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.printf("Name: %s%n", worker.getName());
		System.out.printf("Departament: %s%n", worker.getDepartament().getName());
		System.out.printf("Income for %s: %.2f", monthAndYear, worker.income(year, month));

	
		sc.close();
		
	}
}
