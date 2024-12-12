<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cibertec.models.Usuario"%>

<!DOCTYPE html>
<html>
<head>
    <title>Registro de Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!--Creamos un div donde retornaremos el nombre y la contraseña que son enviados desde el Servlet ValidarSesionServlet-->

     <div class="container mt-5">
           <h1>Bienvenido</h1>
           <li class="list-group-item"><strong>Nombre:</strong> <%= request.getAttribute("nombre") %></li>
           <li class="list-group-item"><strong>Contrasena:</strong> <%= request.getAttribute("contrasena") %></li>


     </div>
</body>
</html>