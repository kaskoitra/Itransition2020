<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User login page</title>
</head>
    <body>
    <form action="LoginServlet" method="post">
        <input class="form-control" name="email" id="email" type="email" placeholder="name@example.com"/>
        <input class="form-control" name="password" id="password" type="password" placeholder="******" />
        <div class="text-xs-center">
            <button class="btn " type="submit">Sign In</button>
        </div>
    </form>
    <a href="/registrationuser" role="button">Register new user</a>
    </body>
</html>