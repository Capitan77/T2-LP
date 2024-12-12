<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cibertec.models.Usuario"%>

<!DOCTYPE html>
<html>
<head>
    <title>Inicio de Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


    <div class="container mt-5">
    <!--Creamos un formulario para iniciar sesión con los nombres y contraseñas de la Base de Datos-->

        <h1>Iniciar Sesión</h1>

        <!--Si el error es diferente de nulo entonces se imprimira un error encima del formulario-->

        <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger">
                <%= request.getAttribute("error") %>
            </div>
        <% } %>

        <!--Inicializamos el formulario diciendo que la accion se enviará al ValidarSesionServlet y sera tipo POST-->
        <form action="ValidarSesionServlet" method="POST">

        <!--Ingresaremos el nombre por medio de input text-->

            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>

         <!--Ingresaremos la contraseña por medio de input password-->

            <div class="mb-3">
                <label for="contrasena" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="contrasena" name="contrasena" required>
            </div>

        <!--Creamos un boton que enviará todos los datos-->

            <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
        </form>
    </div>
</body>
</html>