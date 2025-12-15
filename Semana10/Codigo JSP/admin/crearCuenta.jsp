<%-- 
    Document   : crearCuenta
    Created on : 10 dic. 2025, 7:59:52 p. m.
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
    <title>Administrador - Crear Cuenta</title>
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

    <!-- CONTENIDO CENTRAL -->
    <div class="contenido">

        <h1 class="titulo-seccion">Crear nueva cuenta</h1>

        <form action="../AdminController" method="post" class="formulario">
            <input type="hidden" name="accion" value="crearCuenta">

            <!-- ROL -->
            <label>Rol del usuario</label>
            <select name="rol" id="rol" onchange="cambiarRol()" required>      
                <option value="">Seleccione</option>
                <option value="Estudiante">Estudiante</option>
                <option value="Docente">Docente</option>
                <option value="Admin">Administrador</option>
            </select>
            <!-- CÓDIGO -->
            <label>Código</label>
            <input type="text" id="codigo" name="codigo" placeholder="Ej: t01298h" onkeyup="generarCorreo()" required>

            <!-- NOMBRES -->
            <label>Nombres</label>
            <input type="text" name="nombre" required>

            <!-- APELLIDOS -->
            <label>Apellidos</label>
            <input type="text" name="apellido" required>

            <!-- CORREO AUTOMÁTICO -->
            <label>Correo institucional (automático)</label>
            <input type="text" id="correo" name="correo" readonly required>

            <!-- CONTRASEÑA -->
            <label>Contraseña</label>
            <input type="password" name="contraseña" required>

            <!-- ESPECIALIDAD (solo docente) -->
            <div id="especialidad" style="display:none;">
                <label>Especialidad del docente</label>
                <input type="text" name="especialidad" placeholder="Ej: Sistemas, Enfermería, etc.">
            </div>

            <button class="btn">Registrar cuenta</button>
        </form>

    </div>
<script>
function mostrarCampos() {
    const rol = document.getElementById("rol").value;
    const esp = document.getElementById("especialidad");

    if (rol === "Docente") {
        esp.style.display = "block";
    } else {
        esp.style.display = "none";
    }
}
</script>
    <!-- SCRIPT PARA GENERAR CORREO -->
    <script>
        function generarCorreo() {
            let codigo = document.getElementById("codigo").value.trim();
            let rol = document.getElementById("rol").value;
            let correo = "";

            if (codigo.length > 0) {
                if (rol === "Estudiante") {
                    correo = codigo + "@ms.upla.edu.pe";
                } else if (rol === "Docente") {
                    correo = "d." + codigo + "@ms.upla.edu.pe";
                } else if (rol === "Admin") {
                    correo = "a." + codigo + "@ms.upla.edu.pe";
                }
            }

            document.getElementById("correo").value = correo;

            // mostrar especialidad solo si rol = docente
            document.getElementById("areaDocente").style.display = (rol === "docente") ? "block" : "none";
        }
    </script>
<script>
function cambiarRol() {
    const rol = document.getElementById("rol").value;
    const grupoEsp = document.getElementById("especialidad");

    // Mostrar especialidad solo para docente
    if (rol === "Docente") {
        grupoEsp.style.display = "block";
        document.getElementById("especialidad").required = true;
    } else {
        grupoEsp.style.display = "none";
        document.getElementById("especialidad").required = false;
        document.getElementById("especialidad").value = "";
    }

    // Seguir generando correo
    generarCorreo();
}
</script>
</body>
</html>