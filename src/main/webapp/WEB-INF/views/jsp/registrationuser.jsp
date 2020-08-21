<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registrationuser" method="post">
    <input class="form-control" name="first" id="first" type="first"
           placeholder="last"/>
    <input class="form-control" name="last" id="last" type="last" placeholder="last"/>
    <input class="form-control" name="email" id="email" type="email" placeholder="name@example.com"/>
    <input class="form-control" name="password" id="password" type="password" placeholder="******" />
    <div class="text-xs-center">
        <button class="btn " type="submit">Register</button>
    </div>
</form>
</body>
</html>
