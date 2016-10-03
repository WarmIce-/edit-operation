<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: MyCall
  Date: 9/23/2016
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD</title>
</head>
<body>l
<a href="/list">back to contactList</a>
<h2>Add New Items</h2>
<form action="/insertorupdate" method="get">
    <table>

<tr>
    <td >name:
    </td>
    <td><input type="text" name="name"/></td>

</tr>
        <tr>
            <td>email:</td>
            <td><input type="email" name="email"/></td>
        </tr>

        <tr>
            <td>telephone:</td>
            <td><input type="number" name="telephone"/></td>
        </tr>
        <tr>

            <td>address:</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
        <td><input type="submit" value="button"/></td>
</tr>
    </table>



    </form>
</body>
</html>
