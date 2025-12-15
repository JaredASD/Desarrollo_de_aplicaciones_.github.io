<%-- 
    Document   : inicio
    Created on : 9 dic. 2025, 10:15:54 p. m.
    Author     : Lenovo
--%>

<%@page import="Modelo.Docente"%>
<%@page import="DAO.DocenteDAO"%>
<%@page import="Modelo.Usuario"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<%
DocenteDAO docenteDAO = new DocenteDAO();
Docente docenteAdmin = docenteDAO.obtenerPorIdUsuario(usuario.getIdUsuario());
%>
<!DOCTYPE html>
<html>
<head>
    <title>Administrador - Inicio</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>

<body>

    <!-- MENÚ LATERAL -->
    <div class="menu-lateral">
        <h2>ADMIN</h2>
        <ul>
            <li><a href="admin/inicio.jsp">🏠 Inicio</a></li>
            <li><a href="admin/crearCuenta.jsp">👤 Crear cuentas</a></li>
            <li><a href="admin/gestionarTesis.jsp">📄 Gestionar Tesis</a></li>
            <li><a href="admin/asignarDocente.jsp">📘 Asignar Docente</a></li>
            <li><a href="admin/listadoUsuarios.jsp">📋 Listado Usuarios</a></li>
            <li><a href="admin/resumenProcesos.jsp">📊 Resumen</a></li>
            <li><a href="<%= request.getContextPath() %>/logout.jsp">🚪 Cerrar sesión</a></li>
        </ul>
    </div>

    <!-- PERFIL LATERAL DERECHA -->
    <div class="perfil-lateral">
    <div class="foto"></div>
    <h3>Administrador</h3>

    <% if (docenteAdmin != null) { %>
    <p><strong>Nombre:</strong> <%= docenteAdmin.getNombre() %></p>
        <p><strong>Apellido:</strong> <%= docenteAdmin.getApellido() %></p>
        <p><strong>Código:</strong> <%= docenteAdmin.getCodigo() %></p>
        <p><strong>Correo:</strong> <%= docenteAdmin.getCorreo() %></p>
    <% } else { %>
        <p><em>Datos de docente no encontrados</em></p>
        <p><strong>Correo:</strong> <%= usuario.getCorreo() %></p>
    <% } %>
</div>

    <!-- CONTENIDO CENTRAL -->
    <div class="contenido">
        <h1 class="titulo-seccion">Panel Principal del Administrador</h1>

        <p>Bienvenido al panel administrativo. Desde aquí podrás gestionar estudiantes, docentes, tesis y asignaciones.</p>

        <h2 class="titulo-seccion">Accesos rápidos</h2>

        <button class="btn" onclick="location.href='admin/crearCuenta.jsp'">Crear cuentas</button>
        <button class="btn" onclick="location.href='admin/gestionarTesis.jsp'">Gestionar tesis</button>
        <button class="btn" onclick="location.href='admin/asignarDocente.jsp'">Asignar docentes</button>
        <button class="btn" onclick="location.href='admin/resumenProcesos.jsp'">Ver resumen</button>
    </div>

</body>
</html>