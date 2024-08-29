<%-- 
    Document   : orderCancel
    Created on : Aug 29, 2024, 9:28:03 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Order Cancel Management</h1>

<div class="col-md-10 col-12">
    <a class="btn btn-info m-1" href="<c:url value="/orderCancel/add" />">Add order cancel</a>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Reason</th>
        <th>Date</th>
        <th>Status</th>
        <th>Account Number</th>
        <th>Bank Name</th>
        <th>Order Id</th>
        <th></th>
    </tr>
    <c:forEach items="${orderCancel}" var="o">
        <tr id="orderCancel${o.id}">
            <td>${o.id}</td>
            <td>${o.reason}</td>  
            <td>${o.date}</td>
            <td>${o.status}</td>
            <td>${o.accountNumber}</td>
            <td>${o.bankName}</td>
            <td>${o.orderId.id}</td>
            <td>
                <c:url value="/orderCancel/${o.id}/update" var="u" />
                <a href="${u}" class="btn btn-success m-1">&orarr;</a>

                <c:url value="/api/orderCancel/${o.id}" var="uD" />
                <button onclick="deleteOrderCancel('${uD}', ${o.id})" class="btn btn-danger m-1">&times;</button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
