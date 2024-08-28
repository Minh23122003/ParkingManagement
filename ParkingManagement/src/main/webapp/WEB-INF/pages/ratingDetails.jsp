<%-- 
    Document   : ratingDetails
    Created on : Aug 28, 2024, 10:06:09 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/rating" var="action" />

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="ratingDetails">
    <form:errors path="*" element="div" cssClass="text-danger"/>
    <div class="mb-3 mt-3">
        <label for="stars" class="form-label">Số ngôi sao:</label>
        <form:input path="stars" type="text" class="form-control" id="stars" placeholder="" name="stars" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="browser" class="form-label">Bãi đỗ xe:</label>
        <form:select class="form-select" path="parkingId" >
            <c:forEach items="${getParking}" var="p">
                <c:choose>
                    <c:when test="${p.id == ratingDetails.parkingId.id}">
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
                    <c:when test="${u.id == ratingDetails.userId.id}">
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
                <c:when test="${ratingDetails.id != null}">
                    <option selected>Cập nhật</option>
                </c:when>
                <c:otherwise>
                    Thêm
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
