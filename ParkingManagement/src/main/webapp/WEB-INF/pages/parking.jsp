<%-- 
    Document   : parking
    Created on : Aug 12, 2024, 9:35:10 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Parking Management</h1>

<div class="col-md-10 col-12">
    <a class="btn btn-info m-1" href="<c:url value="/parking/add" />">Add parking</a>
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Address</th>
            <th>Quantity</th>
            <th>Daily price</th>
            <th>Night price</th>
            <th>Status</th>
            <th>Note</th>
            <th></th>
        </tr>
        <c:forEach items="${parking}" var="p">
            <tr id="parking${p.id}">
                <td>${p.id}</td>
                <td>${p.address}</td>
                <td>${p.quantity}</td>
                <td>${p.dailyPrice} VND</td>
                <td>${p.nightPrice} VND</td>
                <td>${p.statusId.name}</td>
                <td>${p.note}</td>
                <td>
                    <c:url value="/parking/${p.id}/update" var="u" />
                    <a href="${u}" class="btn btn-success">&orarr;</a>

                    <c:url value="/api/parking/${p.id}" var="uD" />
                    <button onclick="deleteParking('${uD}', ${p.id})" class="btn btn-danger">&times;</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
