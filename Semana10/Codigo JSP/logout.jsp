<%-- 
    Document   : logout
    Created on : 14 dic. 2025, 10:30:50?p. m.
    Author     : Lenovo
--%>

<%
    if (session != null) {
        session.invalidate();
    }
    response.sendRedirect("login.jsp");
%>
