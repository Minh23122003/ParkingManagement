<%-- 
    Document   : parking
    Created on : Aug 12, 2024, 9:35:10 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-primary mt-1">Quản trị bãi đỗ xe</h1>
<c:url value="/parkings" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="parking">
    <div class="mb-3 mt-3">
        <label for="address" class="form-label">Địa chỉ bãi đỗ xe:</label>
        <form:input path="address" type="text" class="form-control" id="address" placeholder="" name="address" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="quantity" class="form-label">Số lượng:</label>
        <form:input path="quantity" type="number" class="form-control" id="quantity" placeholder="" name="quantity" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="dailyPrice" class="form-label">Giá ngày:</label>
        <form:input path="dailyPrice" type="number" class="form-control" id="dailyPrice" placeholder="" name="dailyPrice" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="nightPrice" class="form-label">Giá đêm:</label>
        <form:input path="nightPrice" type="number" class="form-control" id="nightPrice" placeholder="" name="nightPrice" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="browser" class="form-label">Trạng thái:</label>
        <form:select class="form-select" path="statusId" >
            <c:forEach items="${status}" var="s">
                <c:choose>
                    <c:when test="${s.id == parking.statusId.id}">
                        <option value="${s.id}" selected>${s.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}">${s.name}</option>
                    </c:otherwise>
                </c:choose>           
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3 mt-3">
        <label for="note" class="form-label">Ghi chú:</label>
        <form:input path="note" type="text" class="form-control" id="note" placeholder="" name="note" />      
    </div>
    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <button class="btn btn-success" type="submit">          
            <c:choose>
                <c:when test="${parking.id != null}">
                    <option value="${s.id}" selected>Cập nhật bãi đỗ xe</option>
                </c:when>
                <c:otherwise>
                    Thêm bãi đỗ xe
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>

