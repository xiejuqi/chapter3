<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>新增用户</title>
</head>

<body>
    <form method="post" action="<c:url value="/user.html"/>">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"/> </td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="realName"/> </td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" name="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
