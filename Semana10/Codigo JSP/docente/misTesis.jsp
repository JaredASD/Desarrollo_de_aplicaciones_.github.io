<%-- 
    Document   : evaluaciones
    Created on : 10 dic. 2025, 8:39:24 p. m.
    Author     : Lenovo
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
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
    List<Tesis> tesisAsignadas = new ArrayList<>();

    if (docente != null) {
        tesisAsignadas = tesisDAO.listarPorDocente(docente.getIdDocente());
    }

    // DAO EVALUACION
    EvaluacionDAO evaluacionDAO = new EvaluacionDAO();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Docente - Mis Tesis</title>
    <link rel="stylesheet" href="../css/estilo.css">
</head>
<body>

<!-- MENÚ DOCENTE -->
<div class="menu-lateral">
    <h2>DOCENTE</h2>
    <ul>
        <li><a href="docente/inicio.jsp">🏠 Inicio</a></li>
        <li><a class="activo" href="docente/misTesis.jsp">📄 Mis Tesis</a></li>
        <li><a href="docente/evaluarTesis.jsp">📝 Evaluar Tesis</a></li>
        <li><a href="<%= request.getContextPath() %>/logout.jsp">🚪 Cerrar sesión</a></li>
    </ul>
</div>

<!-- PERFIL -->
<div class="perfil-lateral">
    <div class="foto"></div>
    <h3>Docente</h3>

    <% if (docente != null) { %>
        <p><strong>Nombre:</strong> <%= docente.getNombre() %></p>
        <p><strong>Apellido:</strong> <%= docente.getApellido() %></p>
        <p><strong>Código:</strong> <%= docente.getCodigo() %></p>
        <p><strong>Correo:</strong> <%= docente.getCorreo() %></p>
        <p><strong>Especialidad:</strong> <%= docente.getEspecialidad() %></p>
    <% } %>
</div>

<!-- CONTENIDO -->
<div class="contenido">
    <h2>Mis Tesis Asignadas</h2>

    <% if (tesisAsignadas.isEmpty()) { %>
        <p>No tienes tesis asignadas.</p>
    <% } else { %>

    <table class="tabla-azul">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Estado</th>
            <th>Nota</th>
            <th>PDF</th>
            <th>Acción</th>
        </tr>

        <% for (Tesis t : tesisAsignadas) {
            Evaluacion ev = evaluacionDAO.obtenerPorTesis(t.getIdTesis());
        %>
        <tr>
            <td><%= t.getIdTesis() %></td>
            <td><%= t.getTitulo() %></td>
            <td><%= t.getEstado() %></td>

            <td>
                <%= ev != null ? ev.getNota() : "—" %>
            </td>

            <td>
                <% if (t.getArchivoPDF() != null) { %>
                    <a href="../uploads/<%= t.getArchivoPDF() %>" target="_blank">Ver PDF</a>
                <% } else { %>—<% } %>
            </td>

            <td>
                <% if (ev == null) { %>
                    <a href="evaluarTesis.jsp?idTesis=<%= t.getIdTesis() %>">
                        Evaluar
                    </a>
                <% } else { %>
                    <span style="color:green;">Evaluada</span>
                <% } %>
            </td>
        </tr>
        <% } %>
    </table>

    <% } %>
</div>

</body>
</html>