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
        <title>Listado de categorías</title>
        <s:head></s:head>
        </head>
        <body>
        <s:form action="./alta_Categoria.jsp">
            <s:submit value="Alta categoría"></s:submit>
        </s:form>
        <table class="sortable-theme-bootstrap" data-sortable>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Modificar</th>
                    <th>Borrar</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="%{categorias}">
                    <tr>
                        <td><s:property value="%{nombreCategoria}"></s:property></td>

                            <td>
                            <s:form action="IrModificarCategoria">
                                <s:hidden name="idCategoria" value="%{idCategoria}"></s:hidden>
                                <s:submit value="Modificar"></s:submit>
                            </s:form>
                        </td>
                        <td>
                            <s:form action="borrarCategoria">
                                <s:hidden name="idCategoria" value="%{idCategoria}"></s:hidden>
                                <s:submit value="Borrar"></s:submit>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>

            </tbody>
        </table>
    </body>
</html>
