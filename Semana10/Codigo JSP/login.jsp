<%-- 
    Document   : login
    Created on : 9 dic. 2025, 10:14:07 p. m.
    Author     : Lenovo
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <style>
        body {
            background: #f0f6ff;
            font-family: Arial, sans-serif;
        }

        .login-box {
            width: 360px;
            margin: 120px auto;
            background: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            border-top: 6px solid #1a73e8;
        }

        h2 {
            text-align: center;
            color: #1a73e8;
            margin-bottom: 25px;
            font-weight: bold;
        }

        label {
            display: block;
            font-size: 14px;
            margin-bottom: 8px;
            color: #1a73e8;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 18px;
            border: 1px solid #b7d4ff;
            border-radius: 5px;
            font-size: 15px;
        }

        button {
            width: 100%;
            background: #1a73e8;
            color: white;
            padding: 12px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }

        button:hover {
            background: #155ec4;
        }

        .error-text {
            margin-top: 15px;
            text-align: center;
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="login-box">
    <div style="text-align:center; margin-bottom:15px;">
    <img src="img/LOGO-OFICINA.png" width="150">
</div>
    <h2>Iniciar Sesión</h2>

    <form action="LoginController" method="post">
        <label for="correo">Correo institucional:</label>
        <input type="email" id="correo" name="correo" required>

        <label for="password">Contraseña:</label>
        <input type="password" id="contraseña" name="contraseña" required>

        <button type="submit">Ingresar</button>
    </form>

    <div class="error-text">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </div>
</div>

</body>
</html>