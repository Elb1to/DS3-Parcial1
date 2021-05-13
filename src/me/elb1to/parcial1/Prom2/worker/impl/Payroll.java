package me.elb1to.parcial1.Prom2.worker.impl;

import me.elb1to.parcial1.Prom2.Main;
import me.elb1to.parcial1.Prom2.worker.Worker;
import me.elb1to.parcial1.Prom2.worker.handler.WorkerHandler;

/**
 * Created by Elb1to
 * Project: DS3
 * Date: 5/11/2021 @ 12:04 PM
 */
public class Payroll implements Calculate {

	private final WorkerHandler workerHandler = Main.getWorkerManager();

	@Override
	public void fortnightlyCalculation() {
		for (Worker worker : workerHandler.getWorkersList()) {
			if (worker.getHoursWorked() >= 81 && worker.getHoursWorked() <= 85) {
				worker.setGrossSalary(80 * worker.getHourlyRate() + (worker.getHoursWorked() - 80) * 2 * worker.getHourlyRate());
			} else if (worker.getHoursWorked() > 85) {
				worker.setGrossSalary(80 * worker.getHourlyRate() + (worker.getHoursWorked() - 80) * 3 * worker.getHourlyRate());
			} else {
				worker.setGrossSalary(worker.getHoursWorked() * worker.getHourlyRate());
			}
		}
	}

	@Override
	public void taxCalculation() {
		double valueOfIsr = 0.15, preNetSalary, valueOfSocial, valueOfEducativo, valueOfSeguros;

		for (Worker worker : workerHandler.getWorkersList()) {
			valueOfSocial = worker.getGrossSalary() * 0.0975;
			valueOfEducativo = worker.getGrossSalary() * 0.0125;

			valueOfSeguros = valueOfSocial + valueOfEducativo;
			preNetSalary = worker.getGrossSalary() - valueOfSeguros;
			preNetSalary = preNetSalary * 2 * 13;

			if (preNetSalary > 11000 && preNetSalary < 50000) {
				preNetSalary = ((preNetSalary - 11000) * valueOfIsr) / 13;

				worker.setNetSalary(Math.round(worker.getGrossSalary() - valueOfSeguros - preNetSalary));
			} else {
				worker.setNetSalary(Math.round(worker.getGrossSalary() - valueOfSeguros));
			}
		}
	}
}
