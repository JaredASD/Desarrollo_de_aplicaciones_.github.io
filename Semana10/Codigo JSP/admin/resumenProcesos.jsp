<%-- 
    Document   : resumenProcesos
    Created on : 12 dic. 2025, 6:36:37 p. m.
    Author     : Lenovo
--%>

<%@page import="DAO.DocenteDAO"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="DAO.TesisDAO"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.*, Modelo.*" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    // Aquí deberías obtener datos reales desde DAO
    TesisDAO tesisDAO = new TesisDAO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    DocenteDAO docenteDAO = new DocenteDAO();
    Docente docenteAdmin = docenteDAO.obtenerPorIdUsuario(usuario.getIdUsuario());
    int totalUsuarios = usuarioDAO.contarUsuarios();
    int totalTesis = tesisDAO.contarTesis();
    int tesisPendientes = tesisDAO.contarPorEstado("Pendiente");
    int tesisAprobadas = tesisDAO.contarPorEstado("Aprobada");
    int tesisObservadas = tesisDAO.contarPorEstado("Observada");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resumen de Procesos - Admin</title>
    <link rel="stylesheet" href="../css/estilo.css">
</head>
<body>

<!-- ========== MENÚ LATERAL IZQUIERDO ========== -->
<div class="menu-lateral">
    <h2>ADMIN</h2>
    <ul>
        <li><a href="inicio.jsp">🏠 Inicio</a></li>
        <li><a href="crearCuenta.jsp">👤 Crear cuentas</a></li>
        <li><a href="gestionarTesis.jsp">📄 Gestionar Tesis</a></li>
        <li><a href="asignarDocente.jsp">📘 Asignar Docente</a></li>
        <li><a href="listadoUsuarios.jsp">📋 Listado Usuarios</a></li>
        <li><a href="resumenProcesos.jsp" class="activo">📊 Resumen</a></li>
        <li><a href="<%= request.getContextPath() %>/logout.jsp">🚪 Cerrar sesión</a></li>
    </ul>
</div>

<!-- ========== PERFIL LATERAL DERECHA ========== -->
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

<!-- ========== CONTENIDO CENTRAL ========== -->
<div class="contenido">
    <h1>📊 Resumen General de Procesos</h1>
    <p class="subtitulo">Estado actual del sistema y estadísticas principales.</p>

    <!-- Tarjetas de resumen -->
    <div class="tarjetas-resumen">

        <div class="tarjeta">
            <h2>👥 Usuarios registrados</h2>
            <p class="numero"><%= totalUsuarios %></p>
        </div>

        <div class="tarjeta">
            <h2>📄 Tesis registradas</h2>
            <p class="numero"><%= totalTesis %></p>
        </div>

        <div class="tarjeta">
            <h2>⏳ Tesis pendientes</h2>
            <p class="numero"><%= tesisPendientes %></p>
        </div>

        <div class="tarjeta">
            <h2>✔️ Tesis aprobadas</h2>
            <p class="numero"><%= tesisAprobadas %></p>
        </div>

        <div class="tarjeta">
            <h2>⚠️ Tesis observadas</h2>
            <p class="numero"><%= tesisObservadas %></p>
        </div>

    </div>

    <!-- Tabla detallada -->
    <h2 class="titulo-seccion">📘 Detalle por estado de tesis</h2>

    <table class="tabla">
        <tr>
            <th>Estado</th>
            <th>Cantidad</th>
        </tr>
        <tr>
            <td>Pendientes</td>
            <td><%= tesisPendientes %></td>
        </tr>
        <tr>
            <td>Aprobadas</td>
            <td><%= tesisAprobadas %></td>
        </tr>
        <tr>
            <td>Observadas</td>
            <td><%= tesisObservadas %></td>
        </tr>
        <tr class="total">
            <td><strong>Total</strong></td>
            <td><strong><%= totalTesis %></strong></td>
        </tr>
    </table>

</div>

</body>
</html>