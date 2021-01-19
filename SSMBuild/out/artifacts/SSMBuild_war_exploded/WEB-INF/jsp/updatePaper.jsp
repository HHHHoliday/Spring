<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020年12月20日 0020
  Time: 17:17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改数据</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix"> <%--清除浮动--%>
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>
                        更新书籍
                    </small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%--问题：提交SQL请求但是修改失败。考虑①事务问题，配置aop②看下SQL能否成功：id没传--%>
        <input type="hidden" name="bookID" value="${QBook.bookID}">
        书籍名称：<input type="text" class="form-control" name="bookName" value="${QBook.bookName}" required><br><br><br>
        书籍数量：<input type="text" class="form-control" name="bookCounts" value="${QBook.bookCounts}" required><br><br><br>
        书籍详情：<input type="text" class="form-control" name="detail" value="${QBook.detail}" required><br><br><br>
        <input type="submit" class="form-control" value="修改">
    </form>
</div>
</body>
</html>
