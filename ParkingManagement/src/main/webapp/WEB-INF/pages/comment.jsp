<%-- 
    Document   : comment
    Created on : Aug 29, 2024, 7:13:54 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Comment Management</h1>

<div class="col-md-10 col-12">
    <a class="btn btn-info m-1" href="<c:url value="/comment/add" />">Add comment</a>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Content</th>
        <th>Parking Id</th>
        <th>User Id</th>
        <th></th>
    </tr>
    <c:forEach items="${comment}" var="c">
        <tr id="comment${c.id}">
            <td>${c.id}</td>
            <td>${c.content}</td>  
            <td>${c.parkingId.id}</td>
            <td>${c.userId.id}</td>
            <td>
                <c:url value="/comment/${c.id}/update" var="u" />
                <a href="${u}" class="btn btn-success m-1">&orarr;</a>

                <c:url value="/api/comment/${c.id}" var="uD" />
                <button onclick="deleteComment('${uD}', ${c.id})" class="btn btn-danger m-1">&times;</button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
