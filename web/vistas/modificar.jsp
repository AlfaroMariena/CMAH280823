<%-- 
    Document   : modificar
    Created on : 08-28-2023, 08:26:56 AM
    Author     : Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
    </head>
    <body>
         <h1>Modificar Registros</h1>
 
        <form action="EmpleadosController?accion=actualizar" method="POST" autocomplete="off">
            
           <input type="hidden" id="id" name="id" value="<c:out value="${libros.id}" />" />

            <p>
                Nombre: <input type="text" id="nombre" name="nombre" value="<c:out value="${empleados.nombre}" />" required />
            </p>

            <p>
                Apellido: <input type="text" id="apellido" name="apellido" value="<c:out value="${empleados.apellido }" />" required />
            </p>

            <p>
                Gmail: <input type="text" id="gmail" name="gmail" value="<c:out value="${empleados.gmail}" />" required />
            </p>
            <p>
                Puesto: <input type="text" id="puesto" name="puesto" value="<c:out value="${empleados.puesto}" />" required />
            </p>

            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
           
            
        </form>
    </body>
</html>
