<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<link href="assets/topNavigation.css" rel="stylesheet" type="text/css"/>


<!DOCTYPE html>
<div class="topnav">
    <a class="active" href="<s:url action="listarAnuncios" />">Inicio</a>
    <a href="<s:url action="irAltaAnuncio" />">Alta Anuncio</a>
    <a href="./gestion.jsp">Gestión</a>
    <a href="<s:url action="irListadoMensajes" />">Mis Mensajes</a>
    <s:if test="%{#session.usuario == null}">
        <a href="./login.jsp">Login</a>
        <a href="./registro.jsp">Registro</a>
    </s:if>
    <s:else>
        <a href="./logout.jsp">Cerrar Sesión</a>
    </s:else>
</div>

</html>


