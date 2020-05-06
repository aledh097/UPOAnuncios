<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de anuncios</title>
    </head>
    <body>
        <table border="1" width="1">
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>fechaCreación</th>
                    <th>Código Postal</th>
                    <th>Tipo de anuncio</th>
                    <th>Categoría</th>
                    <th>SubCategoría</th>
                    <th>IdFotos</th>
                    <th>IdUsuario</th>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="%{anuncios}">
                <tr>
                    <td><s:property value="%{titulo}"></s:property></td>
                   <td><s:property value="%{descripcion}"></s:property></td>
                   <td><s:property value="%{precio}"></s:property></td>
                   <td><s:property value="%{fechaCreacion}"></s:property></td>
                   <td><s:property value="%{fkCodPostal}"></s:property></td>
                   <td><s:property value="%{fkIdTipoAnuncio}"></s:property></td>
                   <td><s:property value="%{fkIdCategoria}"></s:property></td>
                   <td><s:property value="%{fkIdSubCategoria}"></s:property></td>
                   <td><s:property value="%{fkIdFotos}"></s:property></td>
                   <td><s:property value="%{fkIdUsuario}"></s:property></td>
                </tr>
            </s:iterator>

        </tbody>
    </table>
</body>
</html>
