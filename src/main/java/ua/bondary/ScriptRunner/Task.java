package ua.bondary.ScriptRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Task implements Runnable {
	protected String taskName;
	protected String command;
	private boolean isFailed;
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public boolean getStatus() {
		return isFailed;
	}
	
	public boolean checkPreCondition() {
		return true;
	}
	
	public boolean checkPostCondition() {
		return true;
	}
	public void run() {
		ProcessBuilder processBuilder;
		if (OS.indexOf("win") >= 0) 
			processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
		else
			processBuilder = new ProcessBuilder("bash", "-c", command);
        try {
        	int exitCode;
            Process process = processBuilder.start();
            String line = new BufferedReader(new InputStreamReader(process.getInputStream())).lines().collect(Collectors.joining("\n"));
            String errorOutput = new BufferedReader(new InputStreamReader(process.getErrorStream())).lines().collect(Collectors.joining("\n"));
            exitCode = process.waitFor();
            if (exitCode == 0) {
            	System.out.println(line);
            	isFailed = !checkPostCondition();
            }	
            else {
                System.out.println(errorOutput);
            }

        } catch (IOException e) {
            e.printStackTrace();
            isFailed = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            isFailed = true;
        }
		//return exitCode;
		
	}

	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", command=" + command + "]";
	};
	
	

}
