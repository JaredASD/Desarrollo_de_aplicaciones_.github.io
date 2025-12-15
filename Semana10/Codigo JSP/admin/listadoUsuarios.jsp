<%-- 
    Document   : listadoUsuarios
    Created on : 10 dic. 2025, 9:41:55 p. m.
    Author     : Lenovo
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="Modelo.*" %>
<%@ page import="DAO.*" %>

<%
    // VALIDAR SESIÓN
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null || !"Admin".equals(usuario.getRol())) {
        response.sendRedirect("../login.jsp");
        return;
    }

    // DAOs
    EstudianteDAO estudianteDAO = new EstudianteDAO();
    DocenteDAO docenteDAO = new DocenteDAO();
    Docente docenteAdmin = docenteDAO.obtenerPorIdUsuario(usuario.getIdUsuario());
    
    List<Estudiante> estudiantes = estudianteDAO.listar();
    List<Docente> docentes = docenteDAO.listar();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Listado de Usuarios</title>
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
</head>
<body>

<!-- MENÚ LATERAL -->
<div class="menu-lateral">
    <h2>ADMIN</h2>
    <ul>
        <li><a href="inicio.jsp">🏠 Inicio</a></li>
        <li><a href="crearCuenta.jsp">👤 Crear cuentas</a></li>
        <li><a href="gestionarTesis.jsp">📄 Gestionar Tesis</a></li>
        <li><a href="asignarDocente.jsp">📘 Asignar Docente</a></li>
        <li><a href="listadoUsuarios.jsp" class="activo">📋 Listado Usuarios</a></li>
        <li><a href="resumenProcesos.jsp">📊 Resumen</a></li>
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

    <h1>📋 Listado de Usuarios</h1>

    <!-- TABLA DE ESTUDIANTES -->
    <h2>Estudiantes</h2>
    <table class="tabla-azul">
        <tr>
            <th>ID</th>
            <th>Código</th>
            <th>Nombre</th>
            <th>Correo</th>
        </tr>

        <% if (estudiantes.isEmpty()) { %>
            <tr><td colspan="4">No hay estudiantes registrados.</td></tr>
        <% } else { 
               for (Estudiante e : estudiantes) { %>
                <tr>
                    <td><%= e.getIdEstudiante() %></td>
                    <td><%= e.getCodigo() %></td>
                    <td><%= e.getNombre() %> <%= e.getApellido() %></td>
                    <td><%= e.getCorreo() %></td>
                </tr>
        <%     }
           } 
        %>
    </table>

    <br>

    <!-- TABLA DE DOCENTES -->
    <h2>Docentes</h2>
    <table class="tabla-azul">
        <tr>
            <th>ID</th>
            <th>Código</th>
            <th>Nombre</th>
            <th>Especialidad</th>
            <th>Correo</th>
        </tr>

        <% if (docentes.isEmpty()) { %>
            <tr><td colspan="5">No hay docentes registrados.</td></tr>
        <% } else { 
               for (Docente d : docentes) { %>
                <tr>
                    <td><%= d.getIdDocente() %></td>
                    <td><%= d.getCodigo() %></td>
                    <td><%= d.getNombre() %> <%= d.getApellido() %></td>
                    <td><%= d.getEspecialidad() %></td>
                    <td><%= d.getCorreo() %></td>
                </tr>
        <%     }
           }
        %>
    </table>

</div>

</body>
</html>
