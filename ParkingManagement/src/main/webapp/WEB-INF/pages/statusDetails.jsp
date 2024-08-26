<%-- 
    Document   : statusDetails
    Created on : Aug 14, 2024, 12:05:19 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/status" var="action" />

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="statusDetails">
    <form:errors path="*" element="div" cssClass="text-danger"/>
    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Tên trạng thái:</label>
        <form:input path="name" type="text" class="form-control" id="name" placeholder="" name="name" />      
    </div>
    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <button class="btn btn-success" type="submit">          
            <c:choose>
                <c:when test="${statusDetails.id != null}">
                    <option selected>Cập nhật trạng thái</option>
                </c:when>
                <c:otherwise>
                    Thêm trạng thái
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>