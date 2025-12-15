<%-- 
    Document   : inicio
    Created on : 10 dic. 2025, 9:19:15 p. m.
    Author     : Lenovo
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="Modelo.*" %>

<%
    Estudiante est = (Estudiante) request.getAttribute("estudiante");
    Tesis tesis = (Tesis) request.getAttribute("tesis");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Estudiante - Inicio</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>

<!-- MENÚ -->
<div class="menu-lateral">
    <h2>ESTUDIANTE</h2>
    <ul>
        <li><a href="<%= request.getContextPath() %>/EstudianteController?accion=inicio">
            🏠 Inicio
        </a></li>
        <li><a href="<%= request.getContextPath() %>/EstudianteController?accion=miTesis">
    📄 Mi Tesis
</a></li>
        <li><a href="<%= request.getContextPath() %>/EstudianteController?accion=miEvaluacion">
    📝 Mi Evaluación
</a></li>
        <li><a href="<%= request.getContextPath() %>/logout.jsp">🚪 Cerrar sesión</a></li>
    </ul>
</div>

<!-- PERFIL -->
<div class="perfil-lateral">
    <div class="foto"></div>
    <h3>Perfil</h3>
    <p><strong>Nombre:</strong> <%= est.getNombre() %> <%= est.getApellido() %></p>
    <p><strong>Código:</strong> <%= est.getCodigo() %></p>
    <p><strong>Correo:</strong> <%= est.getCorreo() %></p>
</div>

<!-- CONTENIDO -->
<div class="contenido">
    <h2>Estado de tu proceso de tesis</h2>

    <% if (tesis == null) { %>
        <p><strong>No tienes una tesis registrada aún.</strong></p>
    <% } else { %>
        <p><strong>Título:</strong> <%= tesis.getTitulo() %></p>
        <p><strong>Estado:</strong> <%= tesis.getEstado() %></p>
    <% } %>
</div>

</body>
</html>