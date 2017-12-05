package seleniumAux;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	private static WebDriver driver = null;
	private static String root = "https://intravita-mant-equipo03.herokuapp.com";


    public static WebDriver getDriver()
    {
    	if (Driver.driver == null)
    	{
    		
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");

    		Driver.driver = new FirefoxDriver();

    	}
    	
        return Driver.driver;
    }
    
    public static void quit()
    {
    	driver.quit();
    }
    
    public static String getRoot()
    {
    	return root;
    }
}
