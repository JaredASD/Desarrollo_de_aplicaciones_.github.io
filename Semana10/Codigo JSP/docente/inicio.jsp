<%-- 
    Document   : inicio
    Created on : 10 dic. 2025, 8:24:45 p. m.
    Author     : Lenovo
--%>

<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="Modelo.*" %>
<%@ page import="DAO.*" %>

<%
    // VALIDAR SESIÓN
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null || !"Docente".equals(usuario.getRol())) {
        response.sendRedirect("../login.jsp");
        return;
    }

    // OBTENER DOCENTE
    DocenteDAO docenteDAO = new DocenteDAO();
    Docente docente = docenteDAO.obtenerPorIdUsuario(usuario.getIdUsuario());

    // TESIS ASIGNADAS
    TesisDAO tesisDAO = new TesisDAO();
    List<Tesis> tesisAsignadas = tesisDAO.listarPorDocente(docente.getIdDocente());
%>

<!DOCTYPE html>
<html>
<head>
    <title>Panel Docente</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>

<!-- MENÚ LATERAL -->
<div class="menu-lateral">
    <h2>DOCENTE</h2>
    <ul>
        <li><a class="activo" href="inicio.jsp">🏠 Inicio</a></li>
        <li><a href="docente/misTesis.jsp">📄 Mis Tesis</a></li>
        <li><a href="docente/evaluarTesis.jsp">📝 Evaluar Tesis</a></li>
        <li><a href="<%= request.getContextPath() %>/logout.jsp">🚪 Cerrar sesión</a></li>
    </ul>
</div>

<!-- PERFIL LATERAL -->
<div class="perfil-lateral">
    <div class="foto"></div>
    <h3>Docente</h3>

    <% if (docente != null) { %>
        <p><strong>Nombre:</strong> <%= docente.getNombre() %></p>
        <p><strong>Apellido:</strong> <%= docente.getApellido() %></p>
        <p><strong>Código:</strong> <%= docente.getCodigo() %></p>
        <p><strong>Correo:</strong> <%= docente.getCorreo() %></p>
        <p><strong>Especialidad:</strong> <%= docente.getEspecialidad() %></p>
    <% } else { %>
        <p><em>Datos del docente no encontrados</em></p>
        <p><strong>Correo:</strong> <%= usuario.getCorreo() %></p>
    <% } %>
</div>

<!-- CONTENIDO -->
<div class="contenido">
    <h2>Bienvenido, <%= docente.getNombre() %> 👋</h2>

    <div class="tarjetas-resumen">

        <div class="tarjeta">
            <h3>Tesis asignadas</h3>
            <p><%= tesisAsignadas.size() %></p>
        </div>

        <div class="tarjeta">
            <h3>Pendientes de evaluar</h3>
            <%
                int pendientes = 0;
                for (Tesis t : tesisAsignadas) {
                    if ("asignada".equals(t.getEstado())) {
                        pendientes++;
                    }
                }
            %>
            <p><%= pendientes %></p>
        </div>

    </div>
</div>

</body>
</html>