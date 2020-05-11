<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de anuncios</title>
        <s:head></s:head>
        </head>
        <body>
        <s:form action="irAltaAnuncio">
            <s:submit value="Alta anuncio"></s:submit>
        </s:form>
        <table border="1" width="1">
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>fechaCreación</th>
                    <th>Municipio</th>
                    <th>Tipo de anuncio</th>
                    <th>Categoría</th>
                    <th>Usuario</th>
                    <th>Modificar</th>
                    <th>Borrar</th>
                </tr>
            </thead>
            <tbody>
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
                        </tr>
                </s:iterator>

            </tbody>
        </table>
    </body>
</html>
