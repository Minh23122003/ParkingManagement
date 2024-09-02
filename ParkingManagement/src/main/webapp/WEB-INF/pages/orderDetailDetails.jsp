<%-- 
    Document   : orderDatailDetails
    Created on : Sep 2, 2024, 8:19:43 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/orderDetail" var="action" />

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="orderDetailDetails">
    <form:errors path="*" element="div" cssClass="text-danger"/>
    <div class="mb-3 mt-3">
        <label for="total" class="form-label">Total:</label>
        <form:input path="total" type="number" class="form-control" id="total" placeholder="" name="total" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="methodPay" class="form-label">Method pay:</label>
        <form:select class="form-select" path="methodPay">
            <c:if test="${orderDetailDetails.methodPay == \"Zalo pay\"}">
                <option value="Momo">Momo</option>
                <option selected value="Zalo pay">Zalo pay</option>
            </c:if>
            <c:if test="${orderDetailDetails.methodPay == \"Momo\"}">
                <option selected value="Momo">Momo</option>
                <option value="Zalo pay">Zalo pay</option>
            </c:if>
            <c:if test="${orderDetailDetails.methodPay == null}">
                <option selected value="Zalo pay">Zalo pay</option>
                <option value="Momo">Momo</option>
            </c:if>
        </form:select>  
    </div>
    <div class="mb-3 mt-3">
        <label for="browser" class="form-label">Order Parking:</label>
        <form:select class="form-select" path="orderId" >
            <c:forEach items="${orderParking}" var="o">
                <c:choose>
                    <c:when test="${o.id == orderDetailDetails.orderId.id}">
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
                <c:when test="${orderDetailDetails.id != null}">
                    <option selected>Update</option>
                </c:when>
                <c:otherwise>
                    Add
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>