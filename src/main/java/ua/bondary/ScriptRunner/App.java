package ua.bondary.ScriptRunner;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String fileName = "tasks.json";
    	
    	PropertyHolder ph = new PropertyHolder("deva.properties");
    	System.out.println(ph.getProp("lem_mdm.password"));
    	
    	 StepExecution e =	new JsonConverter(fileName).parseFile();
    	 try {
			e.startScripts();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
//    	 for (int i=0;i< e.steps.size();i++) {
//    		 for (int j=0;j < e.steps.get(i).size();j++) 
//    			 System.out.println( e.steps.get(i).get(j));
//    	 }
    		  
//    	}
//    	else {
//    		System.out.println("File doesn't exists");
//    	}
//        System.out.println( "Hello World!" );
//        SqlPlusTask sp = new SqlPlusTask("Test dir");
//        sp.run();
//        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "dir C:\\Users\\");
//        try {
//            Process process = processBuilder.start();
//            String line = new BufferedReader(new InputStreamReader(process.getInputStream())).lines().collect(Collectors.joining("\n"));
//            System.out.println(line);
//            int exitCode = process.waitFor();
//            System.out.println("\nExited with error code : " + exitCode);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

}

