<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <s:head></s:head>
    </head>
    <body>       
    <s:form action="comprobarLogin">
            <s:textfield name="correoElectronico" label="Correo electrónico"></s:textfield>
            <s:password name="contrasenya" label="Contraseña"></s:password>
            <s:submit value="Acceder"></s:submit> 
        </s:form>
    </body>
</html>
