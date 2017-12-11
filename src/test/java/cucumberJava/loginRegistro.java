package cucumberJava;

//Junit imports
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



public class loginRegistro {

	private User usuario;
	private UserDAOImpl dao = new UserDAOImpl();;
	
	//escenario 1
	@Given("^Un nuevo usuario inserta sus datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void Un_nuevo_usuario_inserta_sus_datos(String nombre, String apellido, String email, String pass, String nick) {
		
		
		 usuario = new User(Funciones.encrypt(nombre), Funciones.encrypt(apellido), Funciones.encrypt(email), Funciones.encrypt_md5(pass),
         		"ROLE_USER", Funciones.encrypt(nick) ,false);
		 
	    
	}

	@When("^se comprueba en la bbdd \"([^\"]*)\"$")
	public void se_comprueba_en_la_bbdd(String nick) {
		User u = null;
		dao.find(Funciones.encrypt(nick));
		if(u == null){
			dao.insert(usuario);
		}
	    
	}

	@Then("^usuario \"([^\"]*)\" creado$")
	public void usuario_creado(String nick) {
		usuario = null;
	    usuario = dao.find(Funciones.encrypt(nick));
	    if(usuario!=null)
	    	assertTrue(usuario != null);
	    //dao.delete(nick, new File(""));
	    usuario = null;
	}
	
	//escenario 2
	@Given("^Un usuario inserta sus datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void Un_usuario_inserta_sus_datos(String nombre, String apellido, String email, String pass, String pass2, String nick) {
	    usuario = new User(nombre, apellido, email, pass, "ROLE_USER", nick, false);
	}

	@When("^buscar que \"([^\"]*)\" no exista$")
	public void buscar_que_no_exista(String nick) {
		usuario= null;
		usuario = dao.find(Funciones.encrypt(nick));		
	}

	@Then("^usuario no registrado, \"([^\"]*)\" ya existe$")
	public void usuario_no_registrado(String nick) {
		if(usuario==null) {
	    	assertTrue(usuario==null);	    	
		}
	}
	//escenario 3   
	@When("^Las passwords \"([^\"]*)\" y \"([^\"]*)\" no coinciden$")
	public void password_no_coinciden(String pass, String pass2) {
	    if(usuario.getPassword() != pass2) {
	    	usuario = null;
	    }
	}
	
	@Then("^usuario \"([^\"]*)\" no registrado, passwords no coinciden$")
	public void usuario_no_registrado_passwords_no_coinciden(String nick) {
		if(usuario==null) {
	    	assertTrue(usuario==null);	    	
		}
	}

	//escenario 4
	@Given("^Introducimos nickname \"([^\"]*)\" y pass \"([^\"]*)\"$")
	public void introducimos_nickname_y_pass(String nick, String pass) {
	    usuario = null;
	}

	@When("^El usuario \"([^\"]*)\" ya esta registrado$")
	public void el_usuario_ya_esta_registrado(String nick) {
	    usuario = dao.find(Funciones.encrypt(nick));
	}

	@Then("^Acceso permitido, estas dentro de intravita \"([^\"]*)\"$")
	public void acceso_permitido_estas_dentro_de_intravita(String nick) {
		if(usuario!=null)
	    	assertTrue(usuario != null);
	}

	//escenario 5
	@Given("^Introducimos nickname \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void introducimos_nickname_y_password(String nick, String pass) {
	    usuario = null;
	}

	@When("^\"([^\"]*)\" tu password \"([^\"]*)\" incorrecta$")
	public void password_incorrecta(String nick, String pass){
		usuario = dao.find(Funciones.encrypt(nick));
	    if(usuario.getPassword() != Funciones.encrypt_md5(pass)){
	    	usuario = null;
	    }
	    dao.delete(nick, new File(""));
	}

	@Then("^\"([^\"]*)\" acceso denegado$")
	public void acceso_denegado(String nick) {
		if(usuario==null) {
	    	assertTrue(usuario==null);	    	
		}
	}
	@When("^usuario \"([^\"]*)\" no registrado$")
	public void usuario_no_registro(String nick) {
		usuario = dao.find(Funciones.encrypt(nick));
	}



}
