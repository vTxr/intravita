package selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import seleniumAux.Driver;
import seleniumAux.GeneralAux;

public class LoginUsuarioPassIncorrecta {
	private static WebDriver driver;
    private static String root;
    @Test
    public  void loginpasswordin()
    {
    	root = Driver.getRoot();
        driver = Driver.getDriver();
        
        GeneralAux.redirect(root, "/login");
        GeneralAux.login("super.admin", "false", "Contraseña incorrecta");
        
        
    }

}
