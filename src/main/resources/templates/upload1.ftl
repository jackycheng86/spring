<html>
<head>
    <title>文件上传</title>
</head>
<body>
<#if message??>
    <h2>${message}!</h2>
</#if>
<div>
    <form method="POST" enctype="multipart/form-data" action="/file1">
        <table>
            <tr>
                <td>File to upload:</td>
                <td><input type="file" name="file"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Upload"/></td>
            </tr>
        </table>
    </form>
</div>

<div>
    <ul>
        <#if files??>
            <#list files as file>
        <li>
            <a href="${file}">${file}</a>
        </li>
            </#list>
        </#if>

    </ul>
</div>
</body>
</html>