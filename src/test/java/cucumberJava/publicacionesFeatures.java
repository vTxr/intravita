package cucumberJava;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import com.mensubiqua.intravita.dao.UserDAOImpl;
import com.mensubiqua.intravita.model.User;
import com.mensubiqua.intravita.model.Publicacion;
import com.mensubiqua.intravita.auxiliar.Funciones;
import com.mensubiqua.intravita.dao.PublicacionDAOImpl;

//Cucumber imports

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.runtime.*;

import cucumber.api.PendingException;



public class publicacionesFeatures {
	
	private User usuario;
	private UserDAOImpl dao = new UserDAOImpl();
	private PublicacionDAOImpl daoP = new PublicacionDAOImpl();
	private Publicacion p = new Publicacion(); 
	
	//Usuario
	
	private String nombre = "Pepe";
	private String apellido = "ampuero";
	private String email = "user@email.com";
	private String pass = "password";
	private String nick = "pepe";
	
	//Publicaciones
	
	private String texto = "Esto es el texto de la publicacion"; 
	private String fecha = "2017-11-20 12:27";
	private String privacidad = "publica";

	@Given("^Un usuario \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void un_usuario(String nombre, String apellido, String email, String pass, String nick) throws Throwable {
		usuario = new User(Funciones.encrypt(nombre), Funciones.encrypt(apellido), Funciones.encrypt(email), Funciones.encrypt_md5(pass),
         		"ROLE_USER", Funciones.encrypt(nick) ,false);
		
	}

	@Given("^\"([^\"]*)\" escribe publicacion \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void escribe_publicacion(String idPublicacion, String nick ,String texto, String privacidad, String fecha) throws Throwable {
	    p.setNickname(nick);
	    p.setPrivacidad(privacidad);
	    p.setFecha(fecha);
	    p.setTexto(texto);
	    p.setTexto(idPublicacion);
	}
	
	@Given("^publicacion creada \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void publicacion_creada(String nick ,String texto, String privacidad, String fecha, String idPublicacion) throws Throwable {
	   p = new Publicacion();
	   p.setNickname(nick);
	   p.setPrivacidad(privacidad);
	   p.setFecha(fecha);
	   p.setTexto(texto);
	   p.setId(idPublicacion);
	   daoP.insert(p);
	   p = daoP.findNick(nick);
	}

	@When("^inserta publicacion \"([^\"]*)\"$")
	public void inserta_publicacion(String idPublicacion) throws Throwable {
	    daoP.insert(p);
	}

	
	@Then("^publicacion \"([^\"]*)\" creada en bd por \"([^\"]*)\"$")
	public void publicacion_creada_en_bd(String nick, String idPublicacion) throws Throwable {
		p = daoP.findNick(nick);	    
    	assertTrue(p != null);	   
    	daoP.delete(p.getId());
	}
	
	@When("^borra publicacion \"([^\"]*)\"$")
	public void borra_publicacion(String idPublicacion) throws Throwable {
	    daoP.delete(p.getId());
	}

	@Then("^publicacion \"([^\"]*)\"del usuario \"([^\"]*)\" no existe en bd$")
	public void publicacion_no_existe_en_bd(String nick, String idPublicacion) throws Throwable {
	    p = null;
	    p = daoP.findNick(nick);
	    if (p!=null)
	    	assertTrue(p == null);
	    p=null;
	}

	@When("^\"([^\"]*)\" edita publicacion \"([^\"]*)\"$")
	public void edita_publicacion(String privacidad, String nick) throws Throwable {
	    p.setPrivacidad("privada");
	    daoP.update(p);
	}

	@Then("^publicacion \"([^\"]*)\" modificada por \"([^\"]*)\"$")
	public void publicacion_modificada(String nick, String idPublicacion) throws Throwable {
		p = daoP.findNick(nick);
	    assertTrue("publica"!=p.getPrivacidad());
	    daoP.delete(p.getId());
	}


	@When("^Borra usuario \"([^\"]*)\"$")
	public void borra_usuario(String nick) throws Throwable {
	    dao.delete(nick, new File(""));
	}

	@Then("^no hay publicaciones de usuario \"([^\"]*)\"$")
	public void no_hay_publicaciones_de_usuario(String nick) throws Throwable {
	    ArrayList <Publicacion> publicaciones = daoP.findAll(nick);
	   	assertTrue(publicaciones.isEmpty());
		}
	}



