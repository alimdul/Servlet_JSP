<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p align="center" style="color:#ff0099; font-size:30px">СПРАВОЧНИК ПО ВИДАМ ЦВЕТОВ</p> <br><br>
    <form name="showFamilyList" method="post" action="/controller">
        <input type="hidden" name="command" value="show_family_list"/>
        <input type="submit" value="Просмотреть все семейства" align="center"/>
    </form> <br>
</body>
</html>
