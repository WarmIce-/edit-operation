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
        .navbar {
            background-color: blueviolet;

        }
        .content
        {
            background-color: transparent;
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
            <td style="width: 200px;text-align: center">${contact.id}</td>
            <td style="width: 200px;text-align: center">${contact.name}</td>
            <td style="width: 200px;text-align: center">${contact.email}</td>
            <td style="width: 200px;text-align: center">${contact.telephone}</td>
            <td style="width: 200px;text-align: center">${contact.address}</td>
            <td>

                <form id="editContact" class="form-horizontal" action="${pageContext.request.contextPath}/editContact/"
                      method="get">

                        <%--
                        when <input>, <textarea>, and <select> elements [ these are also called form elements]
                        are defined inside <form> tag , then
                        attribute -> 'name' is define inside those elements  which carries a value set to it and that value gets sent to
                        the controller when submit button is pressed.


                        EX: in our case , <input> element which is of type hidden has an attribut called "name" denoted by
                         label 'rowId', i.e  <input type='hidden'  name='rowId'>.
                         This rowId is catched from inside /editContract/ controller. Easy right???  :D
                        --%>

                        <%-- define hidden field having attribute "name" --%>
                    <input type="hidden" name="rowId" id="fetchRowId">
                    <button type="button" class="btn btn-default" onclick="editButtonPressed(this)">
                        <span class="glyphicon glyphicon-pencil"></span>
                        Edit
                    </button>
                    |
                    <button type="button" class="btn btn-danger" onclick="deleteButtonPressed(this)"><span
                            class="glyphicon glyphicon-remove-sign"></span>
                        Delete
                    </button>

                </form>


            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    </div>
</div>

<script>

    function editButtonPressed(thisObj) {

        /* fetch the ID of table row using jquery when edit button is pressed.
         *  If you find below jquery code hard to understand, you need to learn how to use debugger while
         *  writing jquery code.
         * */
        var rowID = $(thisObj).closest("tr").find("td:nth-child(1)").text();


        /* we have defined a hidden field inside <form> tag above, remember??
         * we are setting the value of rowID to that hidden field which we have calculated in above step using jquery
         * */
        $("#fetchRowId").val(rowID);

        /*jquery code to trigger form submit operation.
         * when a form is submitted, it binds the value of rowId to <input> element.
         * and it looks like: <input type="hidden" name="rowId" id="fetchRowId"  value="3"> // eg: 3= rowID
         *
         * when a controller is hit, we can retrieve the value of rowId passed from jsp using ( @RequestParam annotation )
         * */
        $("#editContact").submit();

    }


    function deleteButtonPressed(thisObj) {

        var rowID = $(thisObj).closest("tr").find("td:nth-child(1)").text();
        $("#fetchRowId").val(rowID);
        $("#editContact").attr('action', '${pageContext.request.contextPath}/deleteContact/').submit()
    }


</script>
</body>

</html>

