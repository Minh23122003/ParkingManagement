<%-- 
    Document   : index
    Created on : Aug 1, 2024, 9:13:35 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="container">
    <h1 class="text-center text-info m-1">DANH MỤC BÃI ĐỖ XE</h1>
    <div class="row">
        <div class="col-md-2 col-12 bg-secondary">
            <c:url value="/" var="action" />
            <form action="${action}">
                <div class="mb-3 mt-3">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input type="text" class="form-control" id="address" placeholder="" name="address">
                </div>
                <div class="mb-3 mt-3">
                    <label for="minPrice" class="form-label">Từ giá (VNĐ)(Ngày):</label>
                    <input type="number" class="form-control" id="minPriceDay" placeholder="Từ giá..." name="minPriceDay">
                </div>
                <div class="mb-3 mt-3">
                    <label for="maxPrice" class="form-label">Đến giá (VNĐ)(Ngày):</label>
                    <input type="number" class="form-control" id="maxPriceDay" placeholder="Đến giá..." name="maxPriceDay">
                </div>
                <div class="mb-3 mt-3">
                    <label for="minPrice" class="form-label">Từ giá (VNĐ)(Ðêm):</label>
                    <input type="number" class="form-control" id="minPriceNight" placeholder="Từ giá..." name="minPriceNight">
                </div>
                <div class="mb-3 mt-3">
                    <label for="maxPrice" class="form-label">Đến giá (VNĐ)(Ðêm):</label>
                    <input type="number" class="form-control" id="maxPriceNight" placeholder="Đến giá..." name="maxPriceNight">
                </div>
                <div class="mb-3 mt-3">
                    <label for="statusId" class="form-label">Trạng thái:</label>
                    <select id="statusId" name="statusId" class="form-select" >
                        <c:forEach items="${status}" var="s">
                            <option value="${s.id}" >${s.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3 mt-3">
                    <button class="btn btn-info" type="submit">Tìm kiếm</button>
                </div>
                <div>
                <c:url value="/" var="u" />
                            <a href="${u}" class="btn btn-success">&orarr;</a>    
                </div>
                
            </form>
        </div>
        <div class="col-md-10 col-12">
            <a class="btn btn-info m-1" href="<c:url value="/parkings" />">Thêm bãi đỗ xe</a>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Địa chỉ</th>
                    <th>Số lượng</th>
                    <th>Giá ngày</th>
                    <th>Giá đêm</th>
                    <th>Trạng thái</th>
                    <th>Ghi chú</th>
                    <th></th>
                </tr>
                <c:forEach items="${parkings}" var="p">
                    <tr id="parking${p.id}">
                        <td>${p.id}</td>
                        <td>${p.address}</td>
                        <td>${p.quantity}</td>
                        <td>${p.dailyPrice} VND</td>
                        <td>${p.nightPrice} VND</td>
                        <td>${p.statusId.name}</td>
                        <td>${p.note}</td>
                        <td>
                            <c:url value="/parkings/${p.id}" var="u" />
                            <a href="${u}" class="btn btn-success">&orarr;</a>

                            <c:url value="/api/parkings/${p.id}" var="uD" />
                            <button onclick="deleteParking('${uD}', ${p.id})" class="btn btn-danger">&times;</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>
