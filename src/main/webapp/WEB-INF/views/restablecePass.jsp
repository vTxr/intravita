<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html >
<head>
    <%@ page session="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="${url}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${url}/resources/css/form-elements.css">
    <link rel="stylesheet" href="${url}/resources/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Javascript -->
    <script src="${url}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${url}/resources/js/jquery.backstretch.min.js"></script>
    <script src="${url}/resources/js/scripts.js"></script>

    <!--[if lt IE 10]>
    <script src="${url}/resources/js/placeholder.js"></script>
    <![endif]-->
    
<title> Restablece Password </title>

</head>

<body onload='document.loginForm.username.focus();'>
<script language="JavaScript" type="text/javascript">
		if ("${mensaje2}" != "") {
			alert("${mensaje2}");
		}
	</script>
<div class="top-content">

    <div class="inner-bg">
        <div class="container">

            <div class="row">
                <div class="col-sm-5">

                    <div class="form-box">
                        <div class="form-bottom">
                            <form name='restablecePass' role="form" action="${url}/resPass" method="post" class="login-form">
                            	<h2>Restablece Password</h2>
                                <h3>Lleva mas de 3 meses sin iniciar sesion</h3>
                                <div class="form-group">
                                    <label class="sr-only" for="form-password">Nueva Contraseña</label>
                                    <input type="password" name="password" placeholder="Contraseña" class="form-password form-control" id="form-password">
                                    <label class="sr-only" for="form-password">Repita Contraseña</label>
                                    <input type="password" name="repeatPassword" placeholder="Contraseña" class="form-password form-control" id="form-password">
                                </div>
                                <button id="form-login" type="submit" name="submit" value="submit" class="btn">Restablecer Password</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>