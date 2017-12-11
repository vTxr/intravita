@featuretest
Feature: amistades

Se va a probar la historia de usuario correspondiente a las amistades, las solicitudes de amistad
 y los escenarios alternativos que se generan
 
@Scenario1
Scenario Outline: Enviar nueva solicitud de amistad de pepe a juan
  Given primer usuario "<nombre1>"
  And segundo usuario "<nombre2>"
  When "<nombre1>" envia solicitud a "<nombre2>"
  Then "<nombre2>" tiene solicitud pendiente
  
  Examples: Solicitud enviada
    |nombre1|nombre2|
    |pepe  |juan  |
  
@Scenario2
Scenario Outline: Revocar una solicitud de amistad
  Given primer usuario "<nombre1>"
  And segundo usuario "<nombre2>"
  When "<nombre1>" envia solicitud a "<nombre2>"
  Then "<nombre2>" tiene solicitud pendiente
  
  Examples: Solicitud enviada
    |nombre1|nombre2|
    |pepe  |juan  |
  
@Scenario3
Scenario Outline: Rechazar solicitud de amistad de pepe a juan
  Given primer usuario "<nombre1>"
  And segundo usuario "<nombre2>"
  And "<nombre1>" envia solicitud a "<nombre2>"
  When "<nombre2>" rechaza la solicitud
  Then "<nombre1>" no tiene solicitudes pendientes
  
  Examples: Solicitud enviada
    |nombre1|nombre2|
    |pepe  |juan  |
  
@Scenario4
Scenario Outline: Aceptar solicitud de amistad pepe a juan
  Given primer usuario "<nombre1>"
  And segundo usuario "<nombre2>"
  And "<nombre1>" envia solicitud a "<nombre2>"
  When "<nombre2>" acepta la solicitud
  Then "<nombre1>" y "<nombre2>" son amigos
  
  Examples: Solicitud enviada
    |nombre1|nombre2|
    |pepe  |juan  |