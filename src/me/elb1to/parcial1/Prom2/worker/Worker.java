package me.elb1to.parcial1.Prom2.worker;

/**
 * Created by Elb1to
 * Project: DS3
 * Date: 5/11/2021 @ 11:42 AM
 */
public class Worker {

	private final String name;
	private final double hourlyRate;
	private final int hoursWorked;

	private double grossSalary;
	private double netSalary;

	public Worker(String name, double hourlyRate, int hoursWorked) {
		this.name = name;
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	public String getName() {
		return name;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
}
