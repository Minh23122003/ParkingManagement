<%-- 
    Document   : statsByMonth
    Created on : Sep 2, 2024, 5:05:34 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-primary mt-1">Revenue statistics by month</h1>

<c:url value="/statsByMonth" var="action" />
<form action="${action}">
    <div class="mb-3 mt-3">
        <label for="month" class="form-label">Choose month:</label>
        <input type="month" class="form-control" id="month" placeholder="" name="month">
    </div>
    <div class="mb-3 mt-3">
        <button class="btn btn-info" type="submit">Statistics</button>
    </div>
</form>

<c:if test="${statsByMonth != \"\"}" >
    <div class="row">
        <div class="col-md-5 col-12">
            <table class="table">
                <tr>
                    <th>Id</th>
                    <th>Parking</th>
                    <th>Total</th>
                    <th>Quantity</th>
                </tr>
                <c:forEach items="${statsByMonth}" var="s">
                    <tr>
                        <td>${s[0]}</td>
                        <td>${s[1]}</td>
                        <td>${String.format("%,d", s[2])} VNĐ</td>
                        <td>${s[3]}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-7 col-12">
            <canvas id="myChart"></canvas>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        let labels = [];
        let data = [];
        <c:forEach items="${statsByMonth}" var="s">
    labels.push('${s[1]}');
    data.push(${s[2]});
        </c:forEach>

        window.onload = function () {
            const ctx = document.getElementById('myChart');

            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                            label: 'Revenue',
                            data: data,
                            borderWidth: 1
                        }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });

        }
    </script>
</c:if>
