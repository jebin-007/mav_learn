package learnSelenium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.util.Properties;


public class PropertiesDemo {
	
	public static Logger logger = LogManager.getLogger(PropertiesDemo.class);

	public static void main(String[] args) {
		Properties config = new Properties();
		try {
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\config.properties");
			config.load(fis);
			logger.debug("This is a debug message");
			logger.info("This is a info message");
			logger.error("This is a error message");
			logger.debug("This is a debug message");
			fis.close();
			System.out.println(config.getProperty("browser"));
			System.out.println(config.getProperty("testUrl"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
