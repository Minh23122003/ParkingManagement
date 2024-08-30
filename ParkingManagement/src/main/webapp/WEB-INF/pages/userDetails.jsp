<%-- 
    Document   : userDetails
    Created on : Aug 26, 2024, 9:00:55 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/user" var="action" />

<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="userDetails">
    <form:errors path="*" element="div" cssClass="text-danger"/>
    <div class="mb-3 mt-3">
        <label for="firstName" class="form-label">First name</label>
        <form:input path="firstName" type="text" class="form-control" id="firstName" placeholder="" name="firstName" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="lastName" class="form-label">Last name:</label>
        <form:input path="lastName" type="text" class="form-control" id="lastName" placeholder="" name="lastName" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="email" class="form-label">Email:</label>
        <form:input path="email" type="text" class="form-control" id="email" placeholder="" name="email" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="phone" class="form-label">Phone:</label>
        <form:input path="phone" type="text" class="form-control" id="phone" placeholder="" name="phone" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="username" class="form-label">Username:</label>
        <form:input path="username" type="text" class="form-control" id="username" placeholder="" name="username" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="password" class="form-label">Password:</label>
        <form:input path="password" type="text" class="form-control" id="password" placeholder="" name="password" />      
    </div>
    <div class="mb-3 mt-3">
        <label for="userRole" class="form-label">Role:</label>
        <form:select class="form-select" path="userRole">
            <c:if test="${userDetails.userRole == \"ROLE_ADMIN\"}">
                <option value="ROLE_USER">ROLE_USER</option>
                <option selected value="ROLE_ADMIN">ROLE_ADMIN</option>
            </c:if>
            <c:if test="${userDetails.userRole == \"ROLE_USER\"}">
                <option selected value="ROLE_USER">ROLE_USER</option>
                <option value="ROLE_ADMIN">ROLE_ADMIN</option>
            </c:if>
                <c:if test="${userDetails.userRole == null}">
                <option selected value="ROLE_USER">ROLE_USER</option>
                <option value="ROLE_ADMIN">ROLE_ADMIN</option>
            </c:if>
        </form:select>  
    </div>
    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Avatar:</label>
        <form:input path="file" type="file" accept=".jpg,.png" class="form-control" id="file" name="file" />
        <c:if test="${userDetails.avatar != null}">
            <img class="mt-1" src="${userDetails.avatar}" alt="${userDetails.avatar}" width="120" />
        </c:if>
    </div>
    <div class="mb-3 mt-3">
        <form:hidden path="id" />
        <form:hidden path="avatar" />
        <button class="btn btn-success" type="submit">          
            <c:choose>
                <c:when test="${userDetails.id != null}">
                    <option selected>Update</option>
                </c:when>
                <c:otherwise>
                    Add
                </c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>