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
        <title>Listado de anuncios</title>
        <s:head></s:head>
        </head>
        <body>
        <s:if test="%{#session.usuario == null}">
            <%
                response.sendRedirect("./login.jsp");
            %>
        </s:if>


        <table class="sortable-theme-bootstrap" data-sortable>
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th>Precio (€)</th>
                    <th>fechaCreación</th>
                    <th>Municipio</th>
                    <th>Tipo de anuncio</th>
                    <th>Categoría</th>
                    <th>Usuario</th>
                    <th>Modificar</th>
                    <th>Borrar</th>
                    <th>Enviar Mensaje</th>
                </tr>
            </thead>
            <tbody>

                <jsp:include page="header.jsp" />
            <h1>Listado de anuncios</h1>
            <s:iterator value="%{anuncios}">
                <tr>
                    <td><s:property value="%{titulo}"></s:property></td>
                    <td><s:property value="%{descripcion}"></s:property></td>
                    <td><s:property value="%{precio}"></s:property></td>
                    <td><s:property value="%{fechaCreacion}"></s:property></td>
                    <td><s:property value="%{municipio.nombreMunicipio}"></s:property></td>
                    <td><s:property value="%{tipoanuncio.nombreTipoAnuncio}"></s:property></td>
                    <td><s:property value="%{categoria.nombreCategoria}"></s:property></td>
                    <td><s:property value="%{usuario.nombre}"></s:property></td>
                    <s:if test="%{#session.esAdmin != null || #session.usuario.idUsuario == usuario.idUsuario}">
                        <td>
                            <s:form action="IrModificarAnuncio">
                                <s:hidden name="idAnuncio" value="%{idAnuncio}"></s:hidden>
                                <s:submit value="Modificar"></s:submit>
                            </s:form>
                        </td>
                        <td>
                            <s:form action="borrarAnuncio">
                                <s:hidden name="idAnuncio" value="%{idAnuncio}"></s:hidden>
                                <s:submit value="Borrar"></s:submit>
                            </s:form>
                        </td>
                    </s:if>
                    <s:else>
                        <td></td>
                        <td></td>
                    </s:else>
                    <s:if test="%{#session.usuario.idUsuario != usuario.idUsuario}">
                        <td>
                            <s:form action="enviarMensajeAnuncio">
                                <s:hidden name="idAnuncio" value="%{idAnuncio}"></s:hidden>
                                <s:submit value="Enviar"></s:submit>
                            </s:form>
                        </td>
                    </s:if>
                </tr>
            </s:iterator>

            <jsp:include page="footer.jsp" />

        </tbody>
    </table>
</body>
</html>
