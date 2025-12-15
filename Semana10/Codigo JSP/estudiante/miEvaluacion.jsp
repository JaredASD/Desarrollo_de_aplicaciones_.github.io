<%-- 
    Document   : resultadoEvaluacion
    Created on : 10 dic. 2025, 9:19:46 p. m.
    Author     : Lenovo
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="Modelo.*" %>

<%
    Estudiante est = (Estudiante) request.getAttribute("estudiante");
    Evaluacion eval = (Evaluacion) request.getAttribute("evaluacion");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Mi Evaluación</title>
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

<div class="contenido">
    <h2>Resultado de Evaluación</h2>

    <% if (eval == null) { %>
        <p><em>Aún no has sido evaluado.</em></p>
    <% } else { %>
        <p><strong>Nota Final:</strong> <%= eval.getNota() %></p>
        <p><strong>Comentarios:</strong></p>
        <p><%= eval.getComentarios() %></p>
    <% } %>
</div>

</body>
</html>