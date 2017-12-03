package selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import seleniumAux.Driver;
import seleniumAux.GeneralAux;

public class LoginCorrecto {
	private static WebDriver driver;
    private static String root;
    @Test
    public static void logincorrecto()
    {
    	root = Driver.getRoot();
        driver = Driver.getDriver();
        
        GeneralAux.redirect(root, "/login");
        GeneralAux.login("super.admin", "admin", "");
        GeneralAux.logout();
        
        driver.quit();
        
    }

}
