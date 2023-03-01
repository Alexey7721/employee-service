<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employees Service</title>
</head>
<body>
<h3>Update Employee</h3>
<form:form action="/update" method="post" modelAttribute="employee">
    <form:hidden path="id"/>
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
    <button type="submit">Update</button>
</form:form>
</body>
</html>