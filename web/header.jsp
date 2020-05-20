<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<link href="assets/topNavigation.css" rel="stylesheet" type="text/css"/>


<!DOCTYPE html>
<div class="topnav">
    <a class="active" href="<s:url action="listarAnuncios" />">Inicio</a>
    <a href="<s:url action="irAltaAnuncio" />">Alta Anuncio</a>
    <a href="./gestion.jsp">Gestión</a>
</div>

</html>


