<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<a href="${pageContext.request.contextPath}/admin/category/add">Add Category</a>
<br><br>
<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>Image</th>
        <th>CategoryID</th>
        <th>CategoryName</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${listcate}" var="cate" varStatus="STT">
        <tr>
            <td>${STT.index+1}</td>
            <td>
                <c:if test="${cate.image.substring(0, 5)!='https'}">
                    <c:url value="/image?fname=${cate.image}" var="imgUrl"></c:url>
                </c:if>
                <c:if test="${cate.image.substring(0, 5)=='https'}">
                    <c:url value="${cate.image}" var="imgUrl"></c:url>
                </c:if>
                <img height="250" width="200" src="${imgUrl}"/>
            </td>
            <td>${cate.categoryId}</td>
            <td>${cate.categoryname}</td>
            <td>
                <c:if test="${cate.status ==1}">
                    <span>Hoạt động</span>
                </c:if>
                <c:if test="${cate.status !=1}">
                    <span>Khóa</span>
                </c:if>
            </td>
            <td>
                <a href="<c:url value='/admin/category/edit?id=${cate.categoryId }' />" class="center">Sửa</a>
                |<a href="<c:url value='/admin/category/delete?id=${cate.categoryId }' />" class="center">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table><br>
<a href="${pageContext.request.contextPath}">Back Home</a>