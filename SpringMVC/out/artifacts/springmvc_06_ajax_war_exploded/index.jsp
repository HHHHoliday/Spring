<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021年01月17日 0017
  Time: 12:20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js"></script>
    <script>
      function a(){
        $.post({
          url:"${pageContext.request.contextPath}/a1", //转达到后端的请求
          data:{"name":$("#username").val()},           //传给后端的数据
          success:function(responseData){               //成功的回调函数
            alert(responseData);
          }
        })
      }
    </script>
  </head>
  <body>

    <%--失去焦点时，发起一个请求（携带信息）到后台--%>
    用户名：<input type="text" id="username" onblur="a()">

  </body>
</html>
