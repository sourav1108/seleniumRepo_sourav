package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * This method is used to read data from property file
	 * This method takes keys as a value and return value 
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String getDataFromProperty(String key) throws IOException{
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
}
