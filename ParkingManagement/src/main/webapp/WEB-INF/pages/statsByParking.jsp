<%-- 
    Document   : statsByParking
    Created on : Sep 1, 2024, 9:16:56 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-primary mt-1">Revenue statistics by parking</h1>

<div class="row">
    <div class="col-md-5 col-12">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Parking</th>
                <th>Total</th>
                <th>Quantity</th>
            </tr>
            <c:forEach items="${statsByParking}" var="s">
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
    <c:forEach items="${statsByParking}" var="s">
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
