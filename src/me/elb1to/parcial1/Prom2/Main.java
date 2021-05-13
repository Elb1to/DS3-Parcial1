package me.elb1to.parcial1.Prom2;

import me.elb1to.parcial1.Prom2.worker.handler.WorkerHandler;
import me.elb1to.parcial1.Prom2.worker.impl.Payroll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Elb1to
 * Project: DS3
 * Date: 5/11/2021 @ 11:41 AM
 */
public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	public static WorkerHandler workerHandler = new WorkerHandler();

	public static void main(String[] args) throws IOException {
		String execController;
		Payroll payroll = new Payroll();

		do {
			createWorker();

			System.out.println("Continuar? S/N");
			execController = bufferedReader.readLine();
		} while (execController.equalsIgnoreCase("s"));

		payroll.fortnightlyCalculation();
		payroll.taxCalculation();

		System.out.println("Nombre del Empleado\t\tSalario Bruto\t\tSalario Neto");
		workerHandler.getWorkersList().forEach(worker -> System.out.println(worker.getName() + "\t\t\t | \t\t\t$" + worker.getGrossSalary() + "\t\t\t | \t\t\t$" + worker.getNetSalary()));
	}

	private static void createWorker() {
		String name;
		double hourlyRate;
		int hoursWorked;

		System.out.println("\n");

		try {
			System.out.println("Introduzca el nombre del trabajador: ");
			name = bufferedReader.readLine();

			System.out.println("Introduzca el sueldo por hora de " + name);
			hourlyRate = Double.parseDouble(bufferedReader.readLine());

			System.out.println("Introduzca la cantidad de horas trabajadas por " + name);
			hoursWorked = Integer.parseInt(bufferedReader.readLine());

			workerHandler.addWorker(name, hourlyRate, hoursWorked);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WorkerHandler getWorkerManager() {
		return workerHandler;
	}
}
