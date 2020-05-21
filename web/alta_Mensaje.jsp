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
        </head>
        <body>
            
        <s:if test="%{#session.usuario == null}">
            <%
                response.sendRedirect("./login.jsp");
            %>
        </s:if>

        <jsp:include page="header.jsp" />
            
        <h1>Enviar Mensaje</h1>

        <s:form action="altaMensaje">

            <table border="1"  data-sortable>
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Contenido</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <s:textfield id="input_titulo" name="titulo" required="true" label="Título"></s:textfield>
                        </tr>
                        <tr>
                        <s:textarea id="input_contenido" name="contenido" label="Contenido"></s:textarea>

                        </tr>

                        <tr colspan="2">
                        <s:submit value="Enviar Mensaje"></s:submit>
                        </tr>
                    </tbody>
                </table>
        </s:form>

        <jsp:include page="footer.jsp" />

</html>
