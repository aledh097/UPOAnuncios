<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión de entidades</title>
        <jsp:include page="header.jsp" />
    </head>
    <body>
        <s:if test="%{#session.usuario == null}">
            <%
                response.sendRedirect("./login.jsp");
            %>
        </s:if>

        <h1>Gestión de entidades</h1>
        <s:form action="listarCategorias">
            <s:submit name="gCategorias" value="Gestión categorías"></s:submit>
        </s:form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
