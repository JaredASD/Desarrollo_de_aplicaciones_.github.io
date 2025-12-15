<%-- 
    Document   : evaluar
    Created on : 10 dic. 2025, 8:25:53 p. m.
    Author     : Lenovo
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="Modelo.*" %>
<%@ page import="DAO.*" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null || !"Docente".equals(usuario.getRol())) {
        response.sendRedirect("../login.jsp");
        return;
    }

    int idTesis = Integer.parseInt(request.getParameter("idTesis"));

    TesisDAO tesisDAO = new TesisDAO();
    DocenteDAO docenteDAO = new DocenteDAO();

    Tesis tesis = tesisDAO.obtenerPorId(idTesis);
    Docente docente = docenteDAO.obtenerPorIdUsuario(usuario.getIdUsuario());
%>
<!DOCTYPE html>
<html>
<head>
    <title>Evaluar Tesis</title>
    <link rel="stylesheet" href="../css/estilo.css">

    <script>
        function calcularNota() {
            let total = 0;
            for (let i = 1; i <= 38; i++) {
                let sel = document.getElementById("c" + i);
                if (sel) total += parseFloat(sel.value);
            }
            document.getElementById("notaFinal").value = total.toFixed(2);
            document.getElementById("notaVista").innerText = total.toFixed(2);
        }
    </script>
</head>
<body>

<!-- MENÚ LATERAL -->
<div class="menu-lateral">
    <h2>DOCENTE</h2>
    <ul>
        <li><a href="inicio.jsp">🏠 Inicio</a></li>
        <li><a href="docente/misTesis.jsp">📄 Mis Tesis</a></li>
        <li><a class="activo" href="docente/evaluarTesis.jsp">📝 Evaluar Tesis</a></li>
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

    <h2>Evaluación de Tesis</h2>

    <p><strong>Título:</strong> <%= tesis.getTitulo() %></p>

    <!-- PDF -->
    <iframe src="../uploads/<%= tesis.getArchivoPDF() %>"
            width="100%" height="500px"></iframe>

    <hr>

    <form action="../DocenteController" method="post">
        <input type="hidden" name="accion" value="evaluar">
        <input type="hidden" name="idTesis" value="<%= tesis.getIdTesis() %>">
        <input type="hidden" name="nota" id="notaFinal">

        <table class="table" width="100%">
            <tr>
                <th>#</th>
                <th>Criterio</th>
                <th>Evaluación</th>
            </tr>

            <%
                String[] criterios = {
                    "Es concordante con las variables de estudio, nivel y alcance",
                    "Planteamiento del problema claro",
                    "Objetivos bien definidos",
                    "Justificación adecuada",
                    "Hipótesis coherentes",
                    "Marco teórico pertinente",
                    "Estado del arte actualizado",
                    "Metodología clara",
                    "Diseño de investigación correcto",
                    "Población y muestra adecuada",
                    "Técnicas de recolección válidas",
                    "Instrumentos confiables",
                    "Procedimientos claros",
                    "Análisis de datos correcto",
                    "Resultados coherentes",
                    "Discusión adecuada",
                    "Conclusiones claras",
                    "Recomendaciones pertinentes",
                    "Redacción científica",
                    "Uso adecuado de citas",
                    "Referencias en formato correcto",
                    "Coherencia interna",
                    "Originalidad",
                    "Aporte académico",
                    "Cumple normas APA",
                    "Uso correcto del lenguaje",
                    "Ortografía",
                    "Tablas claras",
                    "Figuras correctas",
                    "Anexos pertinentes",
                    "Consistencia metodológica",
                    "Rigor científico",
                    "Ética de investigación",
                    "Viabilidad",
                    "Impacto académico",
                    "Claridad conceptual",
                    "Orden lógico",
                    "Presentación general"
                };

                for (int i = 0; i < criterios.length; i++) {
            %>
            <tr>
                <td><%= (i + 1) %></td>
                <td><%= criterios[i] %></td>
                <td>
                    <select id="c<%= (i + 1) %>" name="c<%= (i + 1) %>"
                            onchange="calcularNota()" required>
                        <option value="0">No cumple (0)</option>
                        <option value="0.5">Cumple parcialmente (0.5)</option>
                        <option value="1">Cumple (1)</option>
                    </select>
                </td>
            </tr>
            <% } %>
        </table>

        <br>

        <p>
            <strong>Nota Final:</strong>
            <span id="notaVista">0.00</span> / 38
        </p>

        <label>Comentarios finales:</label><br>
        <textarea name="comentarios" rows="5" cols="80" required></textarea>

        <br><br>
        <button type="submit">Enviar Evaluación</button>
    </form>

</div>

</body>
</html>