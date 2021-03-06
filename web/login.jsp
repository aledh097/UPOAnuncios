<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <s:head></s:head>
        <link href="assets/login.css" rel="stylesheet" type="text/css"/>
        </head>
        <body>   
        <jsp:include page="header.jsp" />
        <br><br>
        <div id="divLogin">
        <h1>Iniciar sesión</h1>
            <s:form action="comprobarLogin">
                <s:textfield name="correoElectronico" label="Correo electrónico"></s:textfield>
                <s:password name="contrasenya" label="Contraseña"></s:password>
                <s:submit value="Acceder"></s:submit> 
            </s:form>
             <s:if test="%{#session.logueoIncorrecto != null}">
               <p style="color:red;text-align:center;">¡Datos incorrectos!</p>
            </s:if>
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
