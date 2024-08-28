<%-- 
    Document   : orderParkingDetails
    Created on : Aug 27, 2024, 9:55:18 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/orderParking" var="action" />

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="orderParkingDetails">
    <form:errors path="*" element="div" cssClass="text-danger"/>
    <div class="mb-3 mt-3">
        <label for="vehicleName" class="form-label">Tên phương tiện:</label>
        <form:input path="vehicleName" type="text" class="form-control" id="vehicleName" placeholder="" name="vehicleName" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="licensePlates" class="form-label">Biển số xe:</label>
        <form:input path="licensePlates" type="text" class="form-control" id="licensePlates" placeholder="" name="licensePlates" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="createdDateTransient" class="form-label">Ngày đặt:</label>
        <form:input path="createdDateTransient" type="date" class="form-control" id="createdDateTransient" placeholder="" name="createdDateTransient" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="status" class="form-label">Trạng thái:</label>
        <form:select class="form-select" path="status">
            <c:if test="${orderParkingDetails.status == \"Chưa thanh toán\"}">
                <option value="Đã thanh toán">Đã thanh toán</option>
                <option selected value="Chưa thanh toán">Chưa thanh toán</option>
            </c:if>
            <c:if test="${orderParkingDetails.status == \"Đã thanh toán\"}">
                <option selected value="Đã thanh toán">Đã thanh toán</option>
                <option value="Chưa thanh toán">Chưa thanh toán</option>
            </c:if>
                <c:if test="${orderParkingDetails.status == null}">
                <option selected value="Chưa thanh toán">Chưa thanh toán</option>
                <option value="Đã thanh toán">Đã thanh toán</option>
            </c:if>
        </form:select>  
    </div>
    <div class="mb-3 mt-3">
        <label for="startTimeTransient" class="form-label">Ngày bắt đầu:</label>
        <form:input path="startTimeTransient" type="date" class="form-control" id="startTimeTransient" placeholder="" name="startTimeTransient" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="endTimeTransient" class="form-label">Ngày kết thúc:</label>
        <form:input path="endTimeTransient" type="date" class="form-control" id="endTimeTransient" placeholder="" name="endTimeTransient" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="total" class="form-label">Tổng tiền:</label>
        <form:input path="total" type="number" class="form-control" id="total" placeholder="" name="total" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="browser" class="form-label">Bãi đỗ xe:</label>
        <form:select class="form-select" path="parkingId" >
            <c:forEach items="${getParking}" var="p">
                <c:choose>
                    <c:when test="${p.id == orderParkingDetails.parkingId.id}">
                        <option value="${p.id}" selected>${p.address}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${p.id}">${p.address}</option>
                    </c:otherwise>
                </c:choose>           
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3 mt-3">
        <label for="browser" class="form-label">User:</label>
        <form:select class="form-select" path="userId" >
            <c:forEach items="${user}" var="u">
                <c:choose>
                    <c:when test="${u.id == orderParkingDetails.userId.id}">
                        <option value="${u.id}" selected>${u.username}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${u.id}">${u.username}</option>
                    </c:otherwise>
                </c:choose>           
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <button class="btn btn-success" type="submit">          
            <c:choose>
                <c:when test="${orderParkingDetails.id != null}">
                    <option selected>Cập nhật</option>
                </c:when>
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
