<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<form action="${pageContext.request.contextPath}/admin/video/update" method="post" enctype="multipart/form-data">
    <input type="text" id="videoId" name="videoId" value="${video.videoId}"><br>

    <label for="title">Video Title:</label><br>
    <input type="text" id="title" name="title" value="${video.title}"><br><br>

    <label for="poster">Poster:</label><br>
    <c:if test="${video.poster.substring(0, 5) != 'https'}">
        <c:url value="/image?fname=${video.poster}" var="posterUrl"></c:url>
    </c:if>
    <c:if test="${video.poster.substring(0, 5) == 'https'}">
        <c:url value="${video.poster}" var="posterUrl"></c:url>
    </c:if>
    <img id="images" height="150px" width="150px" src="${posterUrl}" /><br>

    <input type="file" onchange="chooseFile(this)" id="poster" name="poster" value="${video.poster}"><br><br>

    <label for="description">Description:</label><br>
    <textarea id="description" name="description" rows="4" cols="50">${video.description}</textarea><br><br>

    <label for="category">Choose category:</label>
    <select name="category" id="category">
        <c:forEach var="category" items="${categories}">
            <option value="${category.categoryId}" ${category.categoryId == video.category.categoryId ? 'selected' : ''}>${category.categoryname}</option>
        </c:forEach>
    </select><br><br>

    <p>Status:</p>
    <input type="radio" id="active" name="active" value="1" ${video.active == 1 ? 'checked' : ''}>
    <label for="active">Đang hoạt động</label><br>
    <input type="radio" id="inactive" name="active" value="0" ${video.active == 0 ? 'checked' : ''}>
    <label for="inactive">Khóa</label><br><br>

    <input type="submit" value="Update">
</form>
