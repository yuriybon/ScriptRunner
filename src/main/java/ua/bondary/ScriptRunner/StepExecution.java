package ua.bondary.ScriptRunner;

import java.util.ArrayList;
import java.util.List;

public class StepExecution {
	public List<List<Task>> steps;

	public StepExecution() {
		this.steps = new ArrayList<List<Task>>();
	}
	
	public void addStep() {
		this.steps.add(new ArrayList<Task>());
	}
	
	public void addTask(Task task) {
		this.steps.get(steps.size()-1).add(task);
	}
	
	public void startScripts() throws InterruptedException {
		List<Thread> listThread = new ArrayList<Thread>();
   	 for (int i=0;i< steps.size();i++) {
		 for (int j=0;j < steps.get(i).size();j++) {
			 
			 listThread.add(new Thread(steps.get(i).get(j)));
			 listThread.get(listThread.size()-1).start();
		 }	 
		 for (Thread thread:listThread) {
			 if (thread.isAlive() ) {
				 thread.join();
			 }	 
		 }
		 System.out.println("step is finished");
		 listThread.clear();

	 }
	}
	
}
