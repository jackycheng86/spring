<!DOCTYPE html>
<html>
<head>
    <title>Spring Security Example </title>
</head>
<body>
<#if error=="error">
    <div>用户名和密码输入错误！
    </div></#if>

<#if error=="error">
    <div>您已退出登陆！
    </div></#if>
<form action="/login" " method="post">
    <div><label> 用户名 : <input type="text" name="username"/> </label></div>
    <div><label> 密码: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="登陆"/></div>
</form>
</body>
</html>