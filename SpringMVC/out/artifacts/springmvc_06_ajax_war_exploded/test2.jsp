<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021年01月17日 0017
  Time: 19:01:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.js"></script>
    <script>
        //等待页面加载完，再去执行其中的函数
        $(function (){
            $("#btn").click(function (){
                /*
                $.post(url,param[可以省略],success)
                 */
                $.post("${pageContext.request.contextPath}/a2",function(responseData){
                    var html = "<>";

                for(let i=0; i<responseData.length; i++){
                    html += "<tr>"+
                        "<td>"+ responseData[i].name + "</td>"+
                        "<td>"+ responseData[i].age + "</td>"+
                        "<td>"+ responseData[i].sex + "</td>"+
                        "</tr>";
                }

                $("#context").html(html);

                })
            })
        })
    </script>

</head>
<body>

    <input type="button" value="加载数据" id="btn">

    <table>
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
        </tr>
        <tbody id="context">
<%--            数据来自后台--%>
        </tbody>
    </table>

</body>
</html>
