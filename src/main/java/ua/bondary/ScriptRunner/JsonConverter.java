package ua.bondary.ScriptRunner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonConverter {
	String filePath;
	public JsonConverter(String fileName) {
		try {
			filePath = this.getClass().getClassLoader().getResource(fileName).getFile();
		} catch (Exception e) {
			System.out.printf("File %s doesn't exists",fileName);
			filePath = null;
		} 
	}

	public StepExecution parseFile() {
		StepExecution exec = new StepExecution();
		try {
			
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            JSONArray steps= (JSONArray) jsonObject.get("tasks");
            for(int stepId=0; stepId< steps.size(); stepId++){
                JSONArray tasks= (JSONArray) steps.get(stepId);
                exec.addStep();
                for(int taskId=0; taskId<tasks.size(); taskId++){
	            	JSONObject task = (JSONObject) tasks.get(taskId);
	                //System.out.println("The " + taskId + " element of the array: "+task.get("scriptName")+ task.getOrDefault("perCheck","UNKNOWN"));
	                exec.addTask(new SqlPlusTask( (String) task.get("userName"), (String) task.get("scriptName")));  
                }
            }

        } catch (FileNotFoundException ex) {

            ex.printStackTrace();

        } catch (IOException ex) {

            ex.printStackTrace();

        } catch (ParseException ex) {

            ex.printStackTrace();

        } catch (NullPointerException ex) {

            ex.printStackTrace();

        } 
		
		return exec;

    }		
}
