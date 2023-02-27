<%-- 
    Document   : register
    Created on : 2023. 2. 26, 오후 11:03:01
    Author     : third
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
 <h1>Shopping List</h1>
        <form action="" method="post">
            <label>Username: </label>
            <input type="text" name="user_name">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register name">
        </form>
              <p>${message}</p>
    </body>
</html>
