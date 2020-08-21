<%--
  Created by IntelliJ IDEA.
  User: t.kasko
  Date: 19.8.20
  Time: 16.51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  This page is private.
  <li>
      <form:form action="LogoutServlet" method="post">
          <a action="LogoutServlet" href="${pageContext.request.contextPath}/LogoutServlet">Sign Out</a>
      </form:form>
  </li>
</body>
</html>
