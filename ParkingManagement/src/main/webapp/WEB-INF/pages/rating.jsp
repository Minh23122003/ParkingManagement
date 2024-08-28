<%-- 
    Document   : rating
    Created on : Aug 28, 2024, 10:05:58 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Quản trị đánh giá</h1>

<div class="col-md-10 col-12">
    <a class="btn btn-info m-1" href="<c:url value="/rating/add" />">Thêm đánh giá</a>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Số ngôi sao</th>
        <th>Id bãi đỗ xe</th>
        <th>Id user</th>
        <th></th>
    </tr>
    <c:forEach items="${rating}" var="r">
        <tr id="rating${r.id}">
            <td>${r.id}</td>
            <td>${r.stars}</td>  
            <td>${r.parkingId.id}</td>
            <td>${r.userId.id}</td>
            <td>
                <c:url value="/rating/${r.id}/update" var="u" />
                <a href="${u}" class="btn btn-success m-1">&orarr;</a>

                <c:url value="/api/rating/${r.id}" var="uD" />
                <button onclick="deleteRating('${uD}', ${r.id})" class="btn btn-danger m-1">&times;</button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
