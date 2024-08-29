<%-- 
    Document   : orderCancelDetails
    Created on : Aug 29, 2024, 9:28:12 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/orderCancel" var="action" />

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="orderCancelDetails">
    <form:errors path="*" element="div" cssClass="text-danger"/>
    <div class="mb-3 mt-3">
        <label for="reason" class="form-label">Reason:</label>
        <form:input path="reason" type="text" class="form-control" id="reason" placeholder="" name="reason" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="dateTransient" class="form-label">Date:</label>
        <form:input path="dateTransient" type="date" class="form-control" id="dateTransient" placeholder="" name="dateTransient" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="status" class="form-label">Status:</label>
        <form:select class="form-select" path="status">
            <c:if test="${orderCancelDetails.status == \"Đang chờ xử lý\"}">
                <option value="Đã xử lý">Đã xử lý</option>
                <option selected value="Đang chờ xử lý">Đang chờ xử lý</option>
            </c:if>
            <c:if test="${orderCancelDetails.status == \"Đã xử lý\"}">
                <option selected value="Đã xử lý">Đã xử lý</option>
                <option value="Đang chờ xử lý">Đang chờ xử lý</option>
            </c:if>
            <c:if test="${orderCancelDetails.status == null}">
                <option selected value="Đang chờ xử lý">Đang chờ xử lý</option>
                <option value="Đã xử lý">Đã xử lý</option>
            </c:if>
        </form:select>  
    </div>
    <div class="mb-3 mt-3">
        <label for="accountNumber" class="form-label">Account Number:</label>
        <form:input path="accountNumber" type="number" class="form-control" id="accountNumber" placeholder="" name="accountNumber" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="bankName" class="form-label">Bank Name:</label>
        <form:input path="bankName" type="text" class="form-control" id="bankName" placeholder="" name="bankName" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="browser" class="form-label">Order Parking:</label>
        <form:select class="form-select" path="orderId" >
            <c:forEach items="${orderParking}" var="o">
                <c:choose>
                    <c:when test="${o.id == orderCancelDetails.orderId.id}">
                        <option value="${o.id}" selected>${o.id}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${o.id}">${o.id}</option>
                    </c:otherwise>
                </c:choose>           
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <button class="btn btn-success" type="submit">          
            <c:choose>
                <c:when test="${orderCancelDetails.id != null}">
                    <option selected>Update</option>
                </c:when>
                <c:otherwise>
                    Add
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>

