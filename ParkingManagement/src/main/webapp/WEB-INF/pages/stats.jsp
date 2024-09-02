<%-- 
    Document   : stats
    Created on : Aug 31, 2024, 9:20:54 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a class="btn btn-info m-3" href="<c:url value="/statsByParking" />">Statistics by parking</a>
<a class="btn btn-info m-3" href="<c:url value="/statsByUser" />">Statistics by user</a>
<a class="btn btn-info m-3" href="<c:url value="/statsByMonth" />">Statistics by month</a>
<a class="btn btn-info m-3" href="<c:url value="/statsByYear" />">Statistics by year</a>
<a class="btn btn-info m-3" href="<c:url value="/statsByPeriod" />">Statistics by period</a>
