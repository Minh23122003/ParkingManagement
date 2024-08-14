<%-- 
    Document   : statuses
    Created on : Aug 14, 2024, 12:05:05 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Quản trị trạng thái</h1>

<div class="col-md-10 col-12">
    <a class="btn btn-info m-1" href="<c:url value="/statuses/add" />">Thêm trạng thái</a>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Tên trạng thái</th>
        <th></th>
    </tr>
    <c:forEach items="${status}" var="s">
        <tr id="status${s.id}">
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>
                <c:url value="/statuses/${s.id}" var="u" />
                <a href="${u}" class="btn btn-success">&orarr;</a>

                <c:url value="/api/statuses/${s.id}" var="uD" />
                <button onclick="deleteStatus('${uD}', ${s.id})" class="btn btn-danger">&times;</button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>