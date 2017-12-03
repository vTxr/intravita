package selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import seleniumAux.Driver;
import seleniumAux.GeneralAux;


public class LoginConRecuperar {
	private static WebDriver driver;
    private static String root;
    @Test
    public  void loginconrecuperar()
    {
    	root = Driver.getRoot();
        driver = Driver.getDriver();
        
        GeneralAux.redirect(root, "/login");
        GeneralAux.login("prueba", "prueba1234", "");
        GeneralAux.recuperar("1234", "1234");
        driver.quit();
        
    }

}
