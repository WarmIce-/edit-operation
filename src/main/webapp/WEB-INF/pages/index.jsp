<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>INDEX PAGE</title>
    <div class="text-center">
    <h4>${msg}</h4>
        </div>
    <style>
        .navbar
        { background-color: darkgoldenrod;

        }
        .content
        {
            background-color: antiquewhite;
        }
        </style>

</head>
<body>
<div class="container-fluid content">
<a href="/index"><button type="button" class="btn btn-info">Add New Contact</button></a>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Template</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/list"><span class="glyphicon glyphicon-Refresh"></span> Refresh</a></li>
        </ul>
    </div>
</nav>
<div class="container">
<h2>List of items</h2>
<table border="auto">
    <thead style="background: #f9ffb5">
    <tr>
        <td style="width: 200px;text-align: center">ID</td>
        <td style="width: 200px;text-align: center">Name</td>
        <td style="width: 200px;text-align: center">Email</td>
        <td style="width: 200px;text-align: center">Telephone</td>
        <td style="width: 200px;text-align: center">Address</td>
        <td style="width: 200px;text-align: center">Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${List}" varStatus="i" var="contact" >
        <tr class="tr1">
            <td style="width: 200px;text-align: center">${i.index+1}</td>
            <td style="width: 200px;text-align: center">${contact.name}</td>
            <td style="width: 200px;text-align: center">${contact.email}</td>
            <td style="width: 200px;text-align: center">${contact.telephone}</td>
            <td style="width: 200px;text-align: center">${contact.address}</td>
            <td>
                <button class="btn btn-default" onclick="editButtonPressed(this)">
                    <span class="glyphicon glyphicon-pencil"></span>
                    Edit
                </button>
                |
                <button class="btn btn-danger"><span
                        class="glyphicon glyphicon-remove-sign"></span>
                    Delete
                </button>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    </div>
</div>

<script>

    function editButtonPressed(thisObj) {

        /*
         *  NOTICE!!: RABIN ,learn how to use jquery now, but
         *  before you dive deep into jquery, learn how to use debugger first.
         *  if you don't know how to use debugger, see some tutorials, i would recommend seeing video tutorials,
         *  without debugger, learning jquery is a nightmare,
         *
         *
         *  after that , learn how to use "inspect element" feature of browser properly,
         *  learn to see network calls,console,html elements etc inside inspect.
         *
         *  when you start feeling comfortable with inspect-element, you are one step closer to "becoming developer"
         *
         *
         * */


        var rowID = $(thisObj).closest("tr").find("td:nth-child(1)").text();
        var controllerURL = "/editContact/";
        var method = "GET";
        triggerAjax(rowID, controllerURL, method);
    }

    function triggerAjax(rowId, controllerURL, method) {
        $.ajax({
            url: controllerURL + rowId,
            type: method
        });

    }
</script>
</body>

</html>

