<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<form name="from1" action="/hello-web/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="submit" value="springmvc上传文件"/>
</form>
<br/>
<form name="from1" action="/hello-web/file/uploads" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file"/>
    <input type="file" name="upload_file"/>
    <input type="submit" value="springmvc上传文件"/>
</form>

<form name="from2" action="/hello-web/file/download" method="get">
    <input type="submit" value="springmvc下载"/>
</form>
<br/>
</body>
</html>
