<%-- 
    Document   : asignarDocente
    Created on : 10 dic. 2025, 8:06:34 p. m.
    Author     : Lenovo
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.util.*" %>
<%@ page import="Modelo.*" %>
<%@ page import="DAO.*" %>

<%
    // VALIDAR SESIÓN
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null || !"Admin".equals(usuario.getRol())) {
        response.sendRedirect("login.jsp");
        return;
    }

    // DAOs
    TesisDAO tesisDAO = new TesisDAO();
    DocenteDAO docenteDAO = new DocenteDAO();
    Docente docenteAdmin = docenteDAO.obtenerPorIdUsuario(usuario.getIdUsuario());
    // Listar tesis sin docente
    List<Tesis> listaTesisSinDocente = tesisDAO.listarSinDocente();

    // Lista de docentes
    List<Docente> listaDocentes = docenteDAO.listar();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Administrador - asignarDocente</title>
    <link rel="stylesheet" href="../css/estilo.css">
</head>

<body>


    <!-- MENÚ IZQUIERDO -->
    <div class="menu-lateral">
        <h2>ADMIN</h2>
        <ul>
            <li><a href="inicio.jsp">🏠 Inicio</a></li>
            <li><a class="activo" href="crearCuenta.jsp">👤 Crear cuentas</a></li>
            <li><a href="gestionarTesis.jsp">📄 Gestionar Tesis</a></li>
            <li><a href="asignarDocente.jsp">📘 Asignar Docente</a></li>
            <li><a href="listadoUsuarios.jsp">📋 Listado Usuarios</a></li>
            <li><a href="resumenProcesos.jsp">📊 Resumen</a></li>
            <li><a href="<%= request.getContextPath() %>/logout.jsp">🚪 Cerrar sesión</a></li>
        </ul>
    </div>

    <!-- PERFIL DERECHO -->
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

<%
    if (listaTesisSinDocente.isEmpty()) {
%>
        <p><strong>No hay tesis pendientes de asignación.</strong></p>
<%
    } else {
%>
<div class="contenido">
<table class="table">
    <tr>
        <th>ID Tesis</th>
        <th>Título</th>
        <th>Asignar Docente</th>
    </tr>

    <% for (Tesis t : listaTesisSinDocente) { %>
        <tr>
            <td><%= t.getIdTesis() %></td>
            <td><%= t.getTitulo() %></td>

            <td>
                <form action="../AdminController" method="post">
                    <input type="hidden" name="accion" value="asignarDocente">
    <input type="hidden" name="idTesis" value="<%= t.getIdTesis() %>">

    <select name="idDocente" required>
        <option value="">Seleccione docente</option>
        <% for (Docente d : listaDocentes) { %>
            <option value="<%= d.getIdDocente() %>">
                <%= d.getNombre() %> <%= d.getApellido() %>
            </option>
        <% } %>
    </select>

    <button type="submit">Asignar</button>
                </form>
            </td>
        </tr>
    <% } %>

</table>
</div>
<%
    }
%>

</body>
</html>