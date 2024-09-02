<%-- 
    Document   : orderDetail
    Created on : Sep 2, 2024, 8:19:27 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Order Detail Management</h1>

<div class="col-md-10 col-12">
    <a class="btn btn-info m-1" href="<c:url value="/orderDetail/add" />">Add order detail</a>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Total</th>
        <th>Method pay</th>
        <th>Order id</th>
        <th></th>
    </tr>
    <c:forEach items="${orderDetail}" var="o">
        <tr id="orderDetail${o.id}">
            <td>${o.id}</td>
            <td>${o.total}</td>  
            <td>${o.methodPay}</td>
            <td>${o.orderId.id}</td>
            <td>
                <c:url value="/orderDetail/${o.id}/update" var="u" />
                <a href="${u}" class="btn btn-success m-1">&orarr;</a>

                <c:url value="/api/orderDetail/${o.id}" var="uD" />
                <button onclick="deleteOrderDetail('${uD}', ${o.id})" class="btn btn-danger m-1">&times;</button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
