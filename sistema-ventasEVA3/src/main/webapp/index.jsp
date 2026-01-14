<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>My Construction - Login</title>
    <style>
        body { font-family: sans-serif; display: flex; justify-content: center; padding-top: 50px; background: #eee; }
        .card { background: white; padding: 20px; border-radius: 5px; box-shadow: 0 2px 5px rgba(0,0,0,0.2); }
    </style>
</head>
<body>
    <div class="card">
        <h2>Acceso My Construction</h2>
        <form action="login" method="post">
            <p>Usuario: <br><input type="text" name="txtUser" required></p>
            <p>Clave: <br><input type="password" name="txtPass" required></p>
            <button type="submit">Ingresar al Sistema</button>
        </form>
    </div>
</body>
</html>