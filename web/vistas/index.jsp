<%-- 
    Document   : index
    Created on : 08-28-2023, 08:26:23 AM
    Author     : Cortez
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Empleados</title>
</head>
<body>
    <h1>Lista de Empleados</h1>
    
     <a href="EmpleadosController?accion=nuevo">Agregar Empleado</a>
    <table border="1" width="80%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Gmail</th>
            <th>Puesto</th>
           
            <th></th>
            <th></th>
        </tr>
          </thead>
        <c:forEach items="${lista}" var="empleado">
           
            <tr>
                <td>${empleado.id}</td>
                <td>${empleado.nombre}</td>
                <td>${empleado.apellido}</td>
                <td>${empleado.gmail}</td>
                <td>${empleado.puesto}</td>
                
                <td><a href="EmpleadosController?accion=modificar&id=${empleado.id}">Modificar</a></td>
                    <td><a href="EmpleadosController?accion=eliminar&id=${empleado.id}">Eliminar</a></td>
             
                </td>
            </tr>
          
        </c:forEach>
    </table>
    
</body>
</html>
