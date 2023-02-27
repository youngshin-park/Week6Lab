<%-- 
    Document   : shoppingList
    Created on : 2023. 2. 26, 오후 11:04:02
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
        <p>Hello,  ${username}   <a href="ShoppingList?action=logout">Logout</a>
        </p>
        <form action="" method="post">
            <h2>List</h2>
            Add item:  <input type="text" name="item">
            <input type="submit" name="action" value="Add">
        </form>
        <form action="" method="post">
            <c:if test="${itemNumber gt 0}">
                 <c:forEach items="${shoppingItems}" var="shoppingItem">
                     <input type="radio" name="shoppingItem" value=${shoppingItem}>${shoppingItem}<br>
                </c:forEach>
               <input type="submit" name="action" value="Delete">
            </c:if>
        </form>
        
    </body>
</html>