<%-- 
    Document   : user
    Created on : Aug 26, 2024, 9:00:39 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>User Management</h1>

<div class="col-md-10 col-12">
    <a class="btn btn-info m-1" href="<c:url value="/user/add" />">Add user</a>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Username</th>
        <th>Password</th>
        <th>User Role</th>
        <th>Avatar</th>
        <th></th>
    </tr>
    <c:forEach items="${user}" var="u">
        <tr id="user${u.id}">
            <td>${u.id}</td>
            <td>${u.firstName}</td>
            <td>${u.lastName}</td>
            <td>${u.email}</td>
            <td>${u.phone}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
            <td>${u.userRole}</td>
            <td><img src="${u.avatar}" width="120" /></td>
            <td>
                <c:url value="/user/${u.id}/update" var="user" />
                <a href="${user}" class="btn btn-success m-2">&orarr;</a>

                <c:url value="/api/user/${u.id}" var="uD" />
                <button onclick="deleteUser('${uD}', ${u.id})" class="btn btn-danger m-2">&times;</button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
