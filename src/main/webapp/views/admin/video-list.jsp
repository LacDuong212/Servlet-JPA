<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<a href="${pageContext.request.contextPath}/admin/video/add">Add Video</a><br><br>
<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>VideoID</th>
        <th>Title</th>
        <th>Poster</th>
        <th>Description</th>
        <th>Category</th>
        <th>Views</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${listvideo}" var="video" varStatus="STT">
        <tr>
            <td>${STT.index+1}</td>
            <td>${video.videoId}</td>
            <td>${video.title}</td>
            <td>
                <c:if test="${video.poster.substring(0, 5)!='https'}">
                    <c:url value="/image?fname=${video.poster}" var="posterUrl"></c:url>
                </c:if>
                <c:if test="${video.poster.substring(0, 5)=='https'}">
                    <c:url value="${video.poster}" var="posterUrl"></c:url>
                </c:if>
                <img height="150" width="150" src="${posterUrl}" alt="poster"/>
            </td>
            <td>${video.description}</td>
            <td>${video.category.categoryname}</td>
            <td>${video.views}</td>
            <td>
                <c:if test="${video.active == 1}">
                    <span>Hoạt động</span>
                </c:if>
                <c:if test="${video.active != 1}">
                    <span>Khóa</span>
                </c:if>
            </td>
            <td>
                <a href="<c:url value='/admin/video/edit?id=${video.videoId }' />" class="center">Sửa</a>
                |<a href="<c:url value='/admin/video/delete?id=${video.videoId }' />" class="center">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="${pageContext.request.contextPath}">Back Home</a>