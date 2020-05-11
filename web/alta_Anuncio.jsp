<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head></s:head>
        </head>
        <body>
            <h1>Alta Anuncio</h1>

                <s:form action="altaAnuncio">
  
            <table border="1">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>    <s:textfield id="input_titulo" name="titulo" required="true" label="Título"></s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td>    <s:textarea id="input_descripcion" name="descripcion" required="true" label="Descripcion"></s:textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>    <s:textfield id="input_precio" name="precio" required="true" type="number" label="Precio"></s:textfield>
                        </td>
                    </tr>
                    <tr>
                        <td>        <s:select id="fkIdCategoria" name="fkIdCategoria" required="true" list="#session.categorias" listValue="%{nombreCategoria}" listKey="idCategoria" label="Categoria"></s:select>
                        </td>
                    </tr>
                    <tr>
                        <td>        <s:select id="fkCodPostal" name="fkCodPostal" required="true" list="#session.municipios" listValue="%{nombreMunicipio}" listKey="codPostal" label="Municipio"></s:select>
                        </td>
                    </tr>
                                        <tr>
                        <td>        <s:select id="fkIdTipoAnuncio" name="fkIdTipoAnuncio" required="true" list="#session.tiposanuncio" listValue="%{nombreTipoAnuncio}" listKey="idTipoAnuncio" label="Tipo de anuncio"></s:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">       <s:submit value="Dar de alta"></s:submit></td>
                </tr>
            </tbody>
        </table>
                        </s:form>




        <%-- Hola, <s:property value="%{#session.usuario.nombre}"></s:property>--%>
    </body>
</html>
