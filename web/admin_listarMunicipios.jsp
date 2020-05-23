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
        <title>Listado de municipios</title>
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
        <s:form action="./alta_Municipio.jsp">
            <s:submit value="Alta municipio"></s:submit>
        </s:form>
        <table class="sortable-theme-bootstrap" data-sortable>
            <thead>
                <tr>
                    <th>Código Postal</th>
                    <th>Nombre Municipio</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="%{municipios}">
                    <tr>
                        <td><s:property value="%{codPostal}"></s:property></td>
                        <td><s:property value="%{nombreMunicipio}"></s:property></td>

                            <td>
                            <s:form action="IrModificarMunicipio">
                                <s:hidden name="codPostal" value="%{codPostal}"></s:hidden>
                                <s:submit value="Modificar"></s:submit>
                            </s:form>
                        </td>
                        <td>
                            <s:form action="borrarMunicipio">
                                <s:hidden name="codPostal" value="%{codPostal}"></s:hidden>
                                <s:submit value="Borrar"></s:submit>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>

                <jsp:include page="footer.jsp" />

            </tbody>
        </table>
    </body>
</html>
