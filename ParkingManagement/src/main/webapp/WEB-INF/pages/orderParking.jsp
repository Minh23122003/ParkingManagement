<%-- 
    Document   : orderParking
    Created on : Aug 27, 2024, 9:55:05 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>Quản trị đặt bãi đỗ xe</h1>

<div class="col-md-10 col-12">
    <a class="btn btn-info m-1" href="<c:url value="/orderParking/add" />">Đặt bãi đỗ xe</a>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Tên phương tiện</th>
        <th>Biển số xe</th>
        <th>Ngày tạo</th>
        <th>Trạng thái</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
        <th>Tổng tiền</th>
        <th>Id bãi đỗ xe</th>
        <th>Id user</th>
        <th></th>
    </tr>
    <c:forEach items="${orderParking}" var="o">
        <tr id="orderParking${o.id}">
            <td>${o.id}</td>
            <td>${o.vehicleName}</td>
            <td>${o.licensePlates}</td>
            <td>${o.createdDate}</td>
            <td>${o.status}</td>
            <td>${o.startTime}</td>
            <td>${o.endTime}</td>
            <td>${o.total}</td>
            <td>${o.parkingId.id}</td>
            <td>${o.userId.id}</td>
            <td>
                <c:url value="/orderParking/${o.id}/update" var="u" />
                <a href="${u}" class="btn btn-success m-1">&orarr;</a>

                <c:url value="/api/orderParking/${s.id}" var="uD" />
                <button onclick="deleteOrderParking('${uD}', ${o.id})" class="btn btn-danger m-1">&times;</button>
            </td>
        </tr>
    </c:forEach>
</table>
</div>