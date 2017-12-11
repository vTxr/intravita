@featureTest
Feature: userEditar

En este test se va a desarrollar toda la parte correspondiente al panel
de control de los usuarios de la aplicacion. Desde borrar cuenta, editar informacion
del usuario hasta cambiar la password

@Scenario1
Scenario Outline: borrar cuenta
	Given Un usuario registrado en la aplicacion "<nombre>" "<apellido>" "<email>" "<pass>" "<nick>"
	When borra cuenta "<nick>"
	Then usuario "<nick>" no existe en la base de datos

	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|nick		|
    |Miguel|Ampuero |user@email.com	|password	|nickMiguel	|
	
@Scenario2
Scenario Outline: editar informacion
	Given Un usuario registrado en la aplicacion "<nombre>" "<apellido>" "<email>" "<pass>" "<nick>"
	When editar informacion "<nombre>" "<apellido>" "<email>" "<pass>" "<nick>" "<nick2>"
	Then usuario con datos actualizados "<nick2>"

	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|nick		|nick		|
    |Miguel|Ampuero |user@email.com	|password	|nickMiguel	|miguel		|
	
@Scenario3
Scenario Outline: cambiar password
	Given Un usuario registrado en la aplicacion "<nombre>" "<apellido>" "<email>" "<pass>" "<nick>"
	When inserta nueva password "<passNueva>"
	Then password "<pass>" actualizada "<passNueva>"

	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|nick		|passNueva		|
    |Miguel|Ampuero |user@email.com	|password	|nickMiguel	|clave			|
	
@Scenario4
Scenario Outline: cambiar rol a admin
	Given Un usuario registrado en la aplicacion "<nombre>" "<apellido>" "<email>" "<pass>" "<nick>"
	When cambia rol de usuario "<nick>"
	Then rol de "<nick>" actualizado 
	
	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|nick		|rol		|
    |Miguel|Ampuero |user@email.com	|password	|nickMiguel	|ROLE_ADMIN	|