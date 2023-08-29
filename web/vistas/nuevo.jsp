<%-- 
    Document   : nuevo
    Created on : 08-28-2023, 08:26:38 AM
    Author     : Cortez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nuevo Registro de Empleado</title>
</head>
<body>
    <h1>NUEVO REGISTRO</h1>

    <form action="EmpleadosController?accion=insertar" method="POST" autocomplete="off">
        <p>
            Nombre: <input type="text" id="nombre" name="nombre" required autofocus="true" />
        </p>
        <p>
            Apellido: <input type="text" id="apellido" name="apellido" required />
        </p>
        <p>
            Correo: <input type="text" id="gmail" name="gmail" required />
        </p>
        <p>
            Puesto: <input type="text" id="puesto" name="puesto" required />
        </p>

        <button id="guardar" name="guardar" type="submit">Guardar</button>
    </form>
</body>
</html>
