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
<h2>Add/Edit New Items</h2>

<%--insert or update operation should always be performed with "POST" method.
    POST - data are not visible in browser's url.
    GET - data are visible in browser's url. for eg: id can be seen in url when edit operation is performed
--%>
<form:form action="/insertOrUpdate" commandName="contactModel" method="post">
    <form:hidden path="id"/>
    <table>

<tr>
    <td>name:</td>
    <td><form:input path="name"/></td>

</tr>
        <tr>
            <td>email:</td>
            <td><form:input path="email"/></td>
        </tr>

        <tr>
            <td>telephone:</td>
            <td><form:input path="telephone"/></td>
        </tr>
        <tr>
            <td>address:</td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="${saveOrEdit}"/></td>
</tr>
    </table>


</form:form>
</body>
</html>
