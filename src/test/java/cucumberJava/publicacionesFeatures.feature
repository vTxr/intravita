@featureTest
Feature: publicacionesFeature

En este test se va a desarrollar toda la parte correspondiente al gestion de publicaciones, nueva publicacion
editar una publicacion, eliminar una publicacion ya creada y eliminar todas las publicaciones de un usuario eliminado

@Scenario1
Scenario Outline: crear una nueva publicacion
	Given Un usuario "<nombre>" "<apellido>" "<email>" "<pass>" "<nick>"
	And   "<nick>" escribe publicacion "<idPublicacion>" "<texto>" "<fecha>" "<privacidad>"
	When inserta publicacion "<idPublicacion>"
	Then publicacion "<idPublicacion>" creada en bd por "<nick>"

	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|nick		|texto		|fecha		|privacidad		|idPublicacion	|
    |Miguel|Ampuero |user@email.com	|password	|nickMiguel	|Hola amigos|7-12-2017	|publica		|	001			|
	
@Scenario2
Scenario Outline: borrar una publicacion
	Given Un usuario "<nombre>" "<apellido>" "<email>" "<pass>" "<nick>"
	And   publicacion creada "<idPublicacion>" "<texto>" "<fecha>" "<privacidad>" "<nick>"
	When borra publicacion "<idPublicacion>"
	Then publicacion "<idPublicacion>" del usuario "<nick>" no existe en bd

	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|nick		|texto		|fecha		|privacidad		|idPublicacion	|
    |Miguel|Ampuero |user@email.com	|password	|nickMiguel	|Hola amigos|7-12-2017	|publica		|	001			|
	
@Scenario3
Scenario Outline: editar una publicacion
	Given Un usuario "<nombre>" "<apellido>" "<email>" "<pass>" "<nick>"
	And   publicacion creada "<idPublicacion>" "<texto>" "<fecha>" "<privacidad>" "<nick>"
	When "<nick>" edita publicacion "<idPublicacion>"
	Then publicacion "<idPublicacion>" modificada por "<nick>"

	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|nick		|texto				|fecha		|privacidad		|idPublicacion	|
    |Miguel|Ampuero |user@email.com	|password	|nickMiguel	|Hola amigos que tal|9-12-2017	|privada		|	001			|	

@Scenario4
Scenario Outline: eliminar publicaciones de un usuario eliminado
	Given Un usuario "<nombre>" "<apellido>" "<email>" "<pass>" "<nick>"
	And publicacion creada "<idPublicacion>" "<texto>" "<fecha>" "<privacidad>" "<nick>"
	When Borra usuario "<nick>"
	Then no hay publicaciones de usuario "<nick>"

	Examples: Solicitud enviada
    |nombre|apellido|email			|pass		|nick		|texto				|fecha		|privacidad		|idPublicacion	|
    |Miguel|Ampuero |user@email.com	|password	|nickMiguel	|Hola amigos que tal|9-12-2017	|privada		|	001			|