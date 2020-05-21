<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- JQuery -->
<script
    src="https://code.jquery.com/jquery-3.5.1.js"
    integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
crossorigin="anonymous"></script>

<!--  Sortable -->
<link rel="stylesheet" href="./assets/sortable/sortable-theme-bootstrap.css" />
<script src="./assets/sortable/sortable.js"></script>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de mensajes</title>
        <s:head></s:head>
        <jsp:include page="header.jsp" />
    </head>
    <body>

        <s:if test="%{#session.usuario == null}">
            <%
                response.sendRedirect("./login.jsp");
            %>
        </s:if>

        <br><br>
        <table class="sortable-theme-bootstrap" data-sortable>
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Contenido</th>
                    <th>Enviado por</th>
                    <th>Anuncio interesado</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="%{mensajes}">
                    <tr>
                        <td><s:property value="%{titulo}"></s:property></td>
                        <td><s:property value="%{contenido}"></s:property></td>
                        <td><s:property value="%{usuarioByFkIdUsuarioOrigen.correoElectronico}"></s:property></td>
                        <td><s:property value="%{anuncio.titulo}"></s:property></td>
                    </tr>
                </s:iterator>

                <jsp:include page="footer.jsp" />

            </tbody>
        </table>
    </body>
</html>
