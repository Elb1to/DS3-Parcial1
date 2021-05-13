package me.elb1to.parcial1.Prom2.worker.handler;

import me.elb1to.parcial1.Prom2.worker.Worker;

import java.util.ArrayList;

/**
 * Created by Elb1to
 * Project: DS3
 * Date: 5/11/2021 @ 2:11 PM
 */
public class WorkerHandler {

	private final ArrayList<Worker> workersList;

	public WorkerHandler() {
		workersList = new ArrayList<>();
	}

	public void addWorker(String name, double hourlyRate, int hoursWorked) {
		workersList.add(new Worker(name, hourlyRate, hoursWorked));
	}

	public ArrayList<Worker> getWorkersList() {
		return workersList;
	}
}
