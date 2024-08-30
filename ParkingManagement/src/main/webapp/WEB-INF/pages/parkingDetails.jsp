<%-- 
    Document   : parkingDetails
    Created on : Aug 30, 2024, 9:04:24 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/parking" var="action" />

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="parkingDetails">
    <form:errors path="*" element="div" cssClass="text-danger"/>
    <div class="mb-3 mt-3">
        <label for="address" class="form-label">Address:</label>
        <form:input path="address" type="text" class="form-control" id="address" placeholder="" name="address" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="quantity" class="form-label">Quantity:</label>
        <form:input path="quantity" type="number" class="form-control" id="quantity" placeholder="" name="quantity" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="dailyPrice" class="form-label">Daily price:</label>
        <form:input path="dailyPrice" type="number" class="form-control" id="dailyPrice" placeholder="" name="dailyPrice" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="nightPrice" class="form-label">Night price:</label>
        <form:input path="nightPrice" type="number" class="form-control" id="nightPrice" placeholder="" name="nightPrice" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="browser" class="form-label">Status:</label>
        <form:select class="form-select" path="statusId" >
            <c:forEach items="${status}" var="s">
                <c:choose>
                    <c:when test="${s.id == parkingDetails.statusId.id}">
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
        <label for="note" class="form-label">Note:</label>
        <form:input path="note" type="text" class="form-control" id="note" placeholder="" name="note" />      
    </div>
    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <button class="btn btn-success" type="submit">          
            <c:choose>
                <c:when test="${parkingDetails.id != null}">
                    <option value="${s.id}" selected>Update</option>
                </c:when>
                <c:otherwise>
                    Add
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
