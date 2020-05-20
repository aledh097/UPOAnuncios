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
        <jsp:include page="header.jsp" />
    <s:form action="registrarUsuario">
            <s:textfield name="nombre" label="Nombre"></s:textfield>
            <s:textfield name="apellidos" label="Apellidos"></s:textfield>
            <s:textfield name="telefono" label="Teléfono"></s:textfield>
            <s:textfield name="correoElectronico" label="Correo Electrónico"></s:textfield>
            <s:password name="contrasenya" label="Contraseña"></s:password>
            <!--<s:password name="contrasenya" label="Repetir Contraseña"></s:password>-->
            <s:submit value="Acceder"></s:submit> 
        </s:form>
            <jsp:include page="footer.jsp" />
    </body>
</html>