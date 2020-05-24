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
        <title>Modificar municipio</title>
        <s:head></s:head>
        <link href="assets/mod_municipio.css" rel="stylesheet" type="text/css"/>
        </head>

    <jsp:include page="header.jsp" />

    <body>

        <s:if test="%{#session.usuario == null}">
            <%
                response.sendRedirect("./login.jsp");
            %>
        </s:if>
        <div id="divModMunicipio">
            <h1>Modificar Municipio</h1>


            <s:form action="modMunicipio">

                <table border="1" data-sortable>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <s:textfield size="54" id="input_nombre" name="nombreMunicipio" required="true" label="Nombre" value="%{#session.municipio.nombreMunicipio}"></s:textfield>

                            </tr>

                            <tr>
                                <td colspan="2">       <s:submit value="Modificar"></s:submit></td>
                            </tr>
                        </tbody>
                    </table>
            </s:form>
        </div>
        <jsp:include page="footer.jsp" />

</html>
