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
        <title>Alta de anuncio</title>
        <s:head></s:head>
            <link href="assets/alta_anuncio.css" rel="stylesheet" type="text/css"/>
        <jsp:include page="header.jsp" />
    </head>
    <body>

        <s:if test="%{#session.usuario == null}">
            <%
                response.sendRedirect("./login.jsp");
            %>
        </s:if>
        <div id="divAltaAnuncio">
            <h1>Alta Anuncio</h1>

            <s:form action="altaAnuncio">

                <table border="1"  data-sortable>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <s:textfield id="input_titulo" name="titulo" required="true" label="Título"></s:textfield>

                            </tr>
                            <tr>
                            <s:textarea id="input_descripcion" name="descripcion" required="true" label="Descripción"></s:textarea>

                            </tr>
                            <tr>
                            <s:textfield id="input_precio" name="precio" required="true" type="number" label="Precio"></s:textfield>

                            </tr>
                            <tr>
                            <s:select id="fkIdCategoria" name="fkIdCategoria" required="true" list="#session.categorias" listValue="%{nombreCategoria}" listKey="idCategoria" label="Categoría"></s:select>

                            </tr>
                            <tr>
                            <s:select id="fkCodPostal" name="fkCodPostal" required="true" list="#session.municipios" listValue="%{nombreMunicipio}" listKey="codPostal" label="Municipio"></s:select>

                            </tr>
                            <tr>
                            <s:select id="fkIdTipoAnuncio" name="fkIdTipoAnuncio" required="true" list="#session.tiposanuncio" listValue="%{nombreTipoAnuncio}" listKey="idTipoAnuncio" label="Tipo de anuncio"></s:select>

                            </tr>
                            <tr colspan="2">
                            <s:submit value="Dar de alta"></s:submit>
                            </tr>
                        </tbody>
                    </table>

            </s:form>

            <jsp:include page="footer.jsp" />
        </div>

</html>
