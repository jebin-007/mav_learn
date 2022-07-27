package learnSelenium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.util.Properties;


public class Log4JDemo {
	
	public static Logger logger = LogManager.getLogger(Log4JDemo.class);

	public static void main(String[] args) {
		Properties config = new Properties();
		try {
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\resources\\config.properties");
			config.load(fis);
			for ( int i = 0; i < 200; i++) {
				
				logger.debug("This is a debug message for loop : " + i);
				logger.info("This is a info message for loop : " + i);
				logger.error("This is a error message for loop : " + i);
				logger.trace("This is a trace message for loop : " + i);
			}
			System.out.println(config.getProperty("browser"));
			System.out.println(config.getProperty("testUrl"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
