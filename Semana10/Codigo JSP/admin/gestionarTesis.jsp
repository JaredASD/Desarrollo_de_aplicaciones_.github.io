<%-- 
    Document   : gestionarTesis
    Created on : 10 dic. 2025, 9:40:13 p. m.
    Author     : Lenovo
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="DAO.*"%>
<%@page import="Modelo.*"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null || !"Admin".equals(usuario.getRol())) {
        response.sendRedirect("../login.jsp");
        return;
    }

    EstudianteDAO estDAO = new EstudianteDAO();
    TesisDAO tesisDAO = new TesisDAO();
    DocenteDAO docDAO = new DocenteDAO();
    Docente docenteAdmin = docDAO.obtenerPorIdUsuario(usuario.getIdUsuario());

    List<Estudiante> estudiantes = estDAO.listar();
    List<Tesis> tesisList = tesisDAO.listarTodas();
    List<Tesis> tesisLista = tesisDAO.listarConEstudiante();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin - Gestionar Tesis</title>
    <link rel="stylesheet" href="../css/estilo.css">
</head>
<body>

<!-- MENÚ -->
<div class="menu-lateral">
    <h2>ADMIN</h2>
    <ul>
        <li><a href="inicio.jsp">🏠 Inicio</a></li>
        <li><a href="crearCuenta.jsp">👤 Crear cuentas</a></li>
        <li><a href="gestionarTesis.jsp">📄 Gestionar Tesis</a></li>
        <li><a href="asignarDocente.jsp">📘 Asignar Docente</a></li>
        <li><a href="listadoUsuarios.jsp">📋 Listado Usuarios</a></li>
        <li><a href="resumenProcesos.jsp">📊 Resumen</a></li>
        <li><a href="<%= request.getContextPath() %>/logout.jsp">🚪 Cerrar sesión</a></li>
    </ul>
</div>

<!-- PERFIL -->
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

<!-- CONTENIDO -->
<div class="contenido">
    <h2>Registrar nueva tesis</h2>

    <form action="../AdminController" method="post" enctype="multipart/form-data">
        <input type="hidden" name="accion" value="gestionarTesis">

        <label>Título:</label>
        <input type="text" name="titulo" required>

        <label>Estudiante:</label>
        <select name="idEstudiante" required>
            <option value="">Seleccione</option>
            <% for (Estudiante e : estudiantes) { %>
                <option value="<%= e.getIdEstudiante() %>">
                    <%= e.getCodigo() %> - <%= e.getNombre() %> <%= e.getApellido() %>
                </option>
            <% } %>
        </select>

        <label>Archivo PDF:</label>
        <input type="file" name="archivoPDF" accept="application/pdf" required>

        <button type="submit">Subir Tesis</button>
    </form>

    <hr>

    <h2>Listado de Tesis</h2>

    <table border="1" width="100%" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Estudiante</th>
            <th>Docente</th>
            <th>Estado</th>
            <th>PDF</th>
            <th>Acciones</th>
        </tr>

        <% for (Tesis t : tesisLista) {
            Docente d = (t.getIdDocenteAsignado() != null)
                        ? docDAO.obtenerPorIdUsuario(t.getIdDocenteAsignado())
                        : null;
        %>
        <tr>
            <td><%= t.getIdTesis() %></td>
            <td><%= t.getTitulo() %></td>
            <td>
    <%= t.getCodigoEstudiante() %> - 
    <%= t.getNombreEstudiante() %> <%= t.getApellidoEstudiante() %></td>
            <td><%= d != null ? d.getNombre() + " " + d.getApellido() : "Sin asignar" %></td>
            <td><%= t.getEstado() %></td>
            <td>
                <% if (t.getArchivoPDF() != null) { %>
                    <a href="../uploads/<%= t.getArchivoPDF() %>" target="_blank">Ver</a>
                <% } else { %>—<% } %>
            </td>
            <td>
    <form action="../AdminController" method="post" style="display:inline;"
          onsubmit="return confirm('¿Eliminar tesis?')">
        <input type="hidden" name="accion" value="eliminar_tesis">
        <input type="hidden" name="idTesis" value="<%= t.getIdTesis() %>">
        <button type="submit" class="btn">Eliminar</button>
    </form>
</td>
        </tr>
        <% } %>
    </table>
</div>

</body>
</html>