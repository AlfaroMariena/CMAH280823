<%-- 
    Document   : index
    Created on : 08-28-2023, 08:26:23 AM
    Author     : Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de empleados </h1>
        
             <a href="EmpleadosController?accion=nuevo"">Ingresa un nuevo registro </a>

        <br><br/>
        
        <table border="1" width="80%">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Nombre </th>
                    <th>Apellido</th>
                    <th>Correo</th>
                    <th>Puesto</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
              <c:forEach var="empleados" items="${lista}">
                    <tr>
                        <td><c:out value="${empleados.id}"/></td>
                         <td><c:out value="${empleados.nombre}"/></td>
                          <td><c:out value="${empleados.apellido}"/></td>
                           <td><c:out value="${empleados.gmail}"/></td>
                             <td><c:out value="${empleados.puesto}"/></td>
                <td><a href="EmpleadosController?accion=modificar&id=<c:out value="${empleados.id}" />">Modificar</a></td>
                    <td><a href="EmpleadosController?accion=eliminar&id=<c:out value="${empleados.id}" />">Eliminar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
