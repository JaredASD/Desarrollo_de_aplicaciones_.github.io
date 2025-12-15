<%-- 
    Document   : miTesis
    Created on : 10 dic. 2025, 9:19:33 p. m.
    Author     : Lenovo
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="Modelo.*" %>

<%
    Estudiante est = (Estudiante) request.getAttribute("estudiante");
    Tesis tesis = (Tesis) request.getAttribute("tesis");
    Docente docente = (Docente) request.getAttribute("docente");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Mi Tesis</title>
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
    <h2>Mi Tesis</h2>

    <% if (tesis == null) { %>
        <p>No tienes tesis registrada.</p>
    <% } else { %>
        <p><strong>Título:</strong> <%= tesis.getTitulo() %></p>
        <p><strong>Estado:</strong> <%= tesis.getEstado() %></p>

        <% if (tesis.getIdDocenteAsignado() != 0) { %>
    <p><strong>Docente:</strong>
        <%= tesis.getNombreDocente() %> <%= tesis.getApellidoDocente() %>
    </p>
    <p><strong>Correo:</strong> <%= tesis.getCorreoDocente() %></p>
<% } else { %>
    <p><em>Aún no se ha asignado un docente evaluador</em></p>
<% } %>

        <% if (tesis.getArchivoPDF() != null) { %>
            <p>
                <a href="../uploads/<%= tesis.getArchivoPDF() %>" target="_blank">📄 Ver PDF</a>
            </p>
        <% } %>
    <% } %>
</div>

</body>
</html>
