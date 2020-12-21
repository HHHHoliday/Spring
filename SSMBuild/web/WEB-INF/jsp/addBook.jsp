<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020年12月20日 0020
  Time: 15:58:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix"> <%--清除浮动--%>
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>
                        新增书籍
                    </small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        书籍名称：<input type="text" class="form-control" name="bookName" required><br><br><br>
        书籍数量：<input type="text" class="form-control" name="bookCounts" required><br><br><br>
        书籍详情：<input type="text" class="form-control" name="detail" required><br><br><br>
        <input type="submit" class="form-control" value="添加">
    </form>
</div>
</body>
</html>
