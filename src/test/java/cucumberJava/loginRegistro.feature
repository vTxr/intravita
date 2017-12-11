@featureTest
Feature: loginRegistro

Se va a probar la historia de usuario correspondiente al registro de un nuevo
usuario y los escenarios alternativos que se generan

@Scenario1
Scenario Outline: registrar un usuario no existente
	Given Un nuevo usuario inserta sus datos "<nombre>" "<apellido>" "<email>" "<pass>" "<nick>"
	When se comprueba en la bbdd "<nick>"
	Then usuario "<nick>" creado 
	
	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|nick		|
    |Miguel|Ampuero |user@email.com	|password	|nickMiguel	|
	
@Scenario2
Scenario Outline: registrar un usuario ya existente
	Given Un usuario inserta sus datos "<nombre>" "<apellido>" "<email>" "<pass>" "<pass2>" "<nick>"
	When buscar que "<nick>" no exista 
	Then usuario no registrado, "<nick>" ya existe
	
	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|nick		|
    |Miguel|Ampuero |user@email.com	|password	|nickMiguel	|	
    
@Scenario3
Scenario Outline: password1 y password2 no coinciden
	Given Un usuario inserta sus datos "<nombre>" "<apellido>" "<email>" "<pass>" "<pass2>" "<nick>"
	When Las passwords "<pass>" y "<pass2>" no coinciden
	Then usuario "<nick>" no registrado, passwords no coinciden
	
	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|pass2		|nick		|
    |Miguel|Ampuero |user@email.com	|password	|password2	|nickMiguel	|
    
@Scenario4
Scenario Outline: Acceder con cuenta ya creada
	Given Introducimos nickname "<nick>" y pass "<pass>"
	When El usuario "<nick>" ya esta registrado 
	Then Acceso permitido, estas dentro de intravita "<nick>"
	
	Examples: Solicitud enviada
    |nick		|pass		|
    |nickMiguel |password	|	
    
@Scenario5
Scenario Outline: Acceder con password incorrecto
	Given Introducimos nickname "<nick>" y pass "<pass>"
	When "<nick>" tu password "<pass>" incorrecta
	Then "<nick>" acceso denegado 
	
	Examples: Solicitud enviada
    |nick		|pass		|
    |nickMiguel |erronea	|
    
@Scenario6
Scenario Outline: Accedor sin registro
	Given Introducimos nickname "<nick>" y pass "<pass>"
	When usuario "<nick>" no registrado
	Then "<nick>" acceso denegado
	
	Examples: Solicitud enviada
    |nick			|pass			|
    |sinregistrar	|sinregistrar	|
    
	
	