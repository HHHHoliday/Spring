<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021年01月18日 0018
  Time: 10:29:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
  <span>${username}</span>
  <p><a href="${pageContext.request.contextPath}/user/goOut">注销</a> </p>
</body>
</html>
