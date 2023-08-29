<%-- 
    Document   : modificar
    Created on : 08-28-2023, 08:26:56 AM
    Author     : Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modificar Registro de Empleado</title>
</head>
<body>
    <h1>MODIFICAR REGISTRO</h1>

    <form action="EmpleadosController?accion=actualizar" method="POST" autocomplete="off">
        <input type="hidden" name="id" value="${empleado.id}" />

        <p>
            Nombre: <input type="text" id="nombre" name="nombre" value="${empleado.nombre}" required />
        </p>
        <p>
            Apellido: <input type="text" id="apellido" name="apellido" value="${empleado.apellido}" required />
        </p>
        <p>
            Correo: <input type="text" id="gmail" name="gmail" value="${empleado.gmail}" required />
        </p>
        <p>
            Puesto: <input type="text" id="puesto" name="puesto" value="${empleado.puesto}" required />
        </p>

        <button id="actualizar" name="actualizar" type="submit">Actualizar</button>
    </form>
    <br>
    <a href="EmpleadosController">Volver a la lista</a>
</body>
</html>
