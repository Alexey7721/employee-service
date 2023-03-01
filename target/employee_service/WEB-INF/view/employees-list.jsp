<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employees Service</title>
</head>
<body>
<h2>Employees</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Salary</th>
        <th>Department</th>
        <th>View</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.salary}</td>
            <td>${employee.department}</td>
            <td>
                <button onclick="window.location.href = '/view/${employee.id}'">View</button>
            </td>
            <td>
                <button onclick="window.location.href = '/update/${employee.id}'">Update</button>
            </td>
            <td>
                <form action="/delete/${employee.id}" method="post">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<h3>Create new Employee</h3>
<form:form action="/create" method="post" modelAttribute="employee">
    Name: <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Surname: <form:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    Email: <form:input path="email"/>
    <form:errors path="email"/>
    <br><br>
    Phone number: <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br><br>
    Gender:
    <form:radiobutton path="gender" label="Man" value="Man"/>
    <form:radiobutton path="gender" label="Woman" value="Woman"/>
    <form:errors path="gender"/>
    <br><br>
    Salary: <form:input path="salary"/>
    <form:errors path="salary"/>
    <br><br>
    Department:
    <form:select path="department">
        <form:option value="Java dev" label="Java dev"/>
        <form:option value="Python dev" label="Python dev"/>
        <form:option value="Frontend dev" label="Frontend dev"/>
        <form:option value="HR" label="Human Resources"/>
    </form:select>
    <br><br>
    <button type="submit">Create</button>
</form:form>
</body>
</html>