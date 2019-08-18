package ua.bondary.ScriptRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class PropertyHolder {
	
	private Map<String, String> mapProp; 
	
	public PropertyHolder(String path) {
		
		Properties prop = new Properties();
		try {
			prop.load( Thread.currentThread().getContextClassLoader().getResourceAsStream(path) );
			mapProp = prop.entrySet().stream().collect(
				    Collectors.toMap(
				        e -> (String) e.getKey(),
				        e -> (String) e.getValue()
				    ));

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public String getProp(String propName) {
		return mapProp.get(propName);
	}

}
