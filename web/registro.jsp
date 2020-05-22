<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <s:head></s:head>
        <link href="assets/registro.css" rel="stylesheet" type="text/css"/>
        </head>
        <body>     

        <s:if test="%{#session.usuario != null}">
            <%
                response.sendRedirect("./login.jsp");
            %>
        </s:if>

        <jsp:include page="header.jsp" />
        <div id="divRegistro">
            <h1>Registrarse</h1>
            <s:form action="registrarUsuario">
                <br><br>
                <s:textfield name="nombre" label="Nombre"></s:textfield>
                <s:textfield name="apellidos" label="Apellidos"></s:textfield>
                <s:textfield name="telefono" label="Teléfono"></s:textfield>
                <s:textfield name="correoElectronico" label="Correo Electrónico"></s:textfield>
                <s:password name="contrasenya" label="Contraseña"></s:password>
                <!--<s:password name="contrasenya" label="Repetir Contraseña"></s:password>-->
                <s:submit value="Registrarse"></s:submit> 
            </s:form>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>