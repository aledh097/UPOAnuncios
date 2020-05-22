<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

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
        <title>JSP Page</title>
        <s:head></s:head>
        </head>
        
        <jsp:include page="header.jsp" />
        
        <body>

        <s:if test="%{#session.usuario == null}">
            <%
                response.sendRedirect("./login.jsp");
            %>
        </s:if>

        <h1>Modificar Categoría</h1>


        <s:form action="modCategoria">

            <s:hidden name="idCategoria" value="%{idCategoria}"></s:hidden>

                <table border="1" data-sortable>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        <s:textfield size="54" id="input_nombre" name="nombreCategoria" required="true" label="Nombre" value="%{#session.categoria.nombreCategoria}"></s:textfield>

                        </tr>

                        <tr>
                            <td colspan="2">       <s:submit value="Modificar"></s:submit></td>
                        </tr>
                    </tbody>
                </table>
        </s:form>
        
        <jsp:include page="footer.jsp" />

</html>
