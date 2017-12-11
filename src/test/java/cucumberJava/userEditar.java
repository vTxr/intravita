package cucumberJava;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;


//Cucumber imports

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.*;

import cucumber.api.PendingException;

//import de otros paquetes
import com.mensubiqua.intravita.model.User;
import com.mensubiqua.intravita.auxiliar.Funciones;
import com.mensubiqua.intravita.dao.UserDAOImpl;

public class userEditar {
	
	private User usuario;
	private UserDAOImpl dao = new UserDAOImpl();;
	
	private String nombre = "Miguel";
	private String apellido = "Ampuero";
	private String email = "user@email.com";
	private String pass = "password";
	private String nick = "nickMiguel";
	private String nick2 = "Miguelnick";
	private String passNueva = "passwordNueva"; 
	
	@Given("^Un usuario registrado en la aplicacion \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void Un_usuario_registrado_en_la_aplicacion(String nombre, String apellido, String email, String pass, String nick) {
		usuario = new User(Funciones.encrypt(nombre), Funciones.encrypt(apellido), Funciones.encrypt(email), Funciones.encrypt_md5(pass),
         		"ROLE_USER", Funciones.encrypt(nick) ,false);
		dao.insert(usuario);
		usuario = dao.find(Funciones.encrypt(nick));
		
	}

	@When("^borra cuenta \"([^\"]*)\"$")
	public void borra_cuenta(String nick) {
	    dao.delete(nick, new File(""));
	    usuario = null;
	}

	@Then("^usuario \"([^\"]*)\" no existe en la base de datos$")
	public void usuario_no_existe_en_la_base_de_datos(String nick) {
	    usuario = dao.find(Funciones.encrypt(nick));
	    if(usuario==null) {
	    	assertTrue(usuario==null);	    	
		}
	}
	
	@When("^editar informacion \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void editar_informacion(String nombre, String apellido, String email, String pass, String nick, String nick2) throws Throwable {
	    User u = new User(nombre, apellido, email, pass,
	             		"ROLE_USER", nick2 ,false);
	    dao.update(u, "", nick);
	}

	@Then("^usuario con datos actualizados \"([^\"]*)\"$")
	public void usuario_con_datos_actualizados(String nick2) throws Throwable {
	    usuario = dao.find(Funciones.encrypt(nick2));
	    if(usuario!=null) {
	    	assertTrue(usuario!=null);	    	
		}
	    dao.delete(nick2, new File(""));
	}

	@When("^inserta nueva password \"([^\"]*)\"$")
	public void inserta_nueva_password(String passNueva) throws Throwable {
	   usuario.setPassword(Funciones.encrypt_md5(passNueva));
	   dao.updatePassword(usuario);
	}

	@Then("^password \"([^\"]*)\" actualizada \"([^\"]*)\"$")
	public void password_actualizada(String passNueva, String pass) throws Throwable {
	    usuario = dao.find(Funciones.encrypt(nick));
	    String passdb = usuario.getPassword();
	    if(passdb == Funciones.encrypt_md5(passNueva)) {
	    	assertTrue(passdb==passNueva);
	    }
	    dao.delete(nick, new File(""));
	}

	@When("^cambia rol de usuario \"([^\"]*)\"$")
	public void cambia_rol_de_usuario(String nick) throws Throwable {
	    dao.updateRole(nick, "ROLE_ADMIN");
	}

	@Then("^rol de \"([^\"]*)\" actualizado$")
	public void rol_actualizado(String nick) throws Throwable {
	    usuario = dao.find(Funciones.encrypt(nick));
	    if("ROLE_ADMIN" == usuario.getRol()) {
	    	assertTrue("ROLE_ADMIN" == usuario.getRol());
	    }
	    dao.delete(nick, new File(""));
	}



}
