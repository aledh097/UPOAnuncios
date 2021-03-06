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
        <title>JSP Page</title>
        <s:head></s:head>
            <link href="assets/alta_tipoanuncio.css" rel="stylesheet" type="text/css"/>
        </head>
        <body>

        <s:if test="%{#session.usuario == null}">
            <%
                response.sendRedirect("./login.jsp");
            %>
        </s:if>

        <jsp:include page="header.jsp" />
        <div id="divAltaTipoAnuncio">
            <h1>Alta Tipo Anuncio</h1>

            <s:form action="altaTipoAnuncio">

                <table border="1"  data-sortable>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <s:textfield id="input_nombre" name="nombreTipoAnuncio" required="true" label="Nombre"></s:textfield>

                            </tr>

                            <tr colspan="2">
                            <s:submit value="Dar de alta"></s:submit>
                            </tr>
                        </tbody>
                    </table>
            </s:form>
        </div>
        <jsp:include page="footer.jsp" />

</html>
